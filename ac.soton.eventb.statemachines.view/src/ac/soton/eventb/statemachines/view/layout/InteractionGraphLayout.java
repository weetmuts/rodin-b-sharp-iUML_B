/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.layout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.DirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;

import ac.soton.eventb.statemachines.view.editpart.InteractionDiagramEditPart;
import ac.soton.eventb.statemachines.view.editpart.InteractionNodeEditPart;
import ac.soton.eventb.statemachines.view.model.InteractionDiagram;
import ac.soton.eventb.statemachines.view.model.InteractionEdge;
import ac.soton.eventb.statemachines.view.model.InteractionNode;

/**
 * @author vitaly
 *
 */
public class InteractionGraphLayout extends FreeformLayout {

	private InteractionDiagramEditPart diagram;

	/**
	 * 
	 */
	public InteractionGraphLayout(InteractionDiagramEditPart diagram) {
		this.diagram = diagram;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void layout(IFigure parent) {
		Map<InteractionNode, Node> map = new HashMap<InteractionNode, Node>();
		InteractionDiagram diagramModel = (InteractionDiagram) diagram.getModel();
		
		// graph
		DirectedGraph graph = new DirectedGraph();
		graph.setMargin(new Insets(20));
		
		// nodes
		for (InteractionNode inode : diagramModel.getNodes()) {
			Node node = new Node(inode);
			graph.nodes.add(node);
			map.put(inode, node);
		}
		int i = 0;
		// edges
		for (InteractionEdge iedge : diagramModel.getEdges()) {
			Edge edge = new Edge(iedge, map.get(iedge.getSource()), map.get(iedge.getTarget()));
			edge.weight = i++;
			graph.edges.add(edge);
		}
		
		// run layout algorithm
		new DirectedGraphLayout().visit(graph);
		
		// lay out figures according to results
		for (Object child : diagram.getChildren())
			if (child instanceof InteractionNodeEditPart) {
				InteractionNodeEditPart part = (InteractionNodeEditPart) child;
				InteractionNode inode = (InteractionNode) part.getModel();
				Node node = map.get(inode);
				part.getFigure().setLocation(new Point(node.x, node.y));
//				part.getFigure().validate();
			}
		

		Iterator children = parent.getChildren().iterator();
		Point offset = getOrigin(parent);
		IFigure f;
		while (children.hasNext()) {
			f = (IFigure) children.next();
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;

			if (bounds.width == -1 || bounds.height == -1) {
				Dimension preferredSize = f.getPreferredSize(bounds.width,
						bounds.height);
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = preferredSize.width;
				if (bounds.height == -1)
					bounds.height = preferredSize.height;
			}
			
			bounds.x = 5;
			bounds.y = 10;
			
			bounds = bounds.getTranslated(offset);
			f.setBounds(bounds);
		}
	}

}
