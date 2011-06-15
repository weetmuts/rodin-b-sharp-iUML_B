/**
 * Copyright (c) 2011 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.view.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbsoluteBendpoint;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.graph.DirectedGraph;
import org.eclipse.draw2d.graph.DirectedGraphLayout;
import org.eclipse.draw2d.graph.Edge;
import org.eclipse.draw2d.graph.Node;
import org.eclipse.draw2d.graph.NodeList;
import org.eclipse.gef.EditPart;

import ac.soton.eventb.statemachines.view.editpart.InteractionDiagramEditPart;
import ac.soton.eventb.statemachines.view.editpart.InteractionEdgeEditPart;
import ac.soton.eventb.statemachines.view.editpart.InteractionNodeEditPart;
import ac.soton.eventb.statemachines.view.figure.InteractionConnectionFigure;

/**
 * Custom interaction graph layout.
 * Uses DirectedGraphLayout and DirectedGraph instance to lay out the diagram elements
 * of a freeform layout.
 * 
 * @author vitaly
 *
 */
public class InteractionGraphLayout extends FreeformLayout {
	
	private static final Insets PADDING = new Insets(30);
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
	@Override
	public void layout(IFigure parent) {
		
		// build graph
		DirectedGraph graph = new DirectedGraph();
		Map<EditPart, Object> partsToGraph = new HashMap<EditPart, Object>();
		contributeNodesToGraph(graph, partsToGraph);
		contributeEdgesToGraph(graph, partsToGraph);
		
		// run graph layout algorithm
		graph.setDefaultPadding(PADDING);
		new DirectedGraphLayout().visit(graph);
		
		// apply results on view layout
		applyGraphResults(parent, graph, partsToGraph);
	}

	/**
	 * Adds nodes from diagram to graph.
	 * 
	 * @param graph
	 * @param partsToGraph
	 */
	@SuppressWarnings("unchecked")
	private void contributeNodesToGraph(DirectedGraph graph, Map<EditPart, Object> partsToGraph) {
		for (Object child : diagram.getChildren()) {
			if (child instanceof InteractionNodeEditPart) {
				InteractionNodeEditPart part = (InteractionNodeEditPart) child;
				Node node = new Node(part);
				node.width = part.getFigure().getClientArea().width;
				node.height = part.getFigure().getClientArea().height;
				partsToGraph.put(part, node);
				graph.nodes.add(node);
			}
		}
	}

	/**
	 * Adds edges from diagram to graph.
	 * 
	 * @param graph
	 * @param partsToGraph
	 */
	@SuppressWarnings("unchecked")
	private void contributeEdgesToGraph(DirectedGraph graph, Map<EditPart, Object> partsToGraph) {
		for (Object child : diagram.getChildren()) {
			if (child instanceof InteractionNodeEditPart) {
				for (Object connection : ((InteractionNodeEditPart) child).getSourceConnections()) {
					if (connection instanceof InteractionEdgeEditPart) {
						InteractionEdgeEditPart part = (InteractionEdgeEditPart) connection;
						Node source = (Node) partsToGraph.get(part.getSource());
						Node target = (Node) partsToGraph.get(part.getTarget());
						Edge edge = new Edge(part, source, target);
						edge.weight = 2;
						graph.edges.add(edge);
						partsToGraph.put(part, edge);
					}
				}
			}
		}
	}

	/**
	 * Applies graph results to diagram children figures.
	 * 
	 * @param parent parent figure
	 * @param graph
	 * @param partsToGraph
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void applyGraphResults(IFigure parent, DirectedGraph graph, Map<EditPart, Object> partsToGraph) {
		Point offset = getOrigin(parent);
		for (Object obj : diagram.getChildren()) {
			if (obj instanceof InteractionNodeEditPart) {
				InteractionNodeEditPart part = (InteractionNodeEditPart) obj;
				Rectangle bounds = (Rectangle) getConstraint(part.getFigure());
				if (bounds == null)
					continue;
	
				if (bounds.width == -1 || bounds.height == -1) {
					Dimension preferredSize = part.getFigure().getPreferredSize(bounds.width,
							bounds.height);
					bounds = bounds.getCopy();
					if (bounds.width == -1)
						bounds.width = preferredSize.width;
					if (bounds.height == -1)
						bounds.height = preferredSize.height;
				} else if (partsToGraph.containsKey(part)) {
					// set bounds for node
					Node node = (Node) partsToGraph.get(part);
					bounds.x = node.x;
					bounds.y = node.y;
					
					// set constraints for connections
					for (Object connection : part.getSourceConnections()) {
						Edge e = (Edge) partsToGraph.get(connection);
						NodeList nodes = e.vNodes;
						InteractionConnectionFigure conn = (InteractionConnectionFigure) ((InteractionEdgeEditPart) connection).getFigure();
						if (nodes != null) {
							List bends = new ArrayList();
							for (int i = 0; i < nodes.size(); i++) {
								Node vn = nodes.getNode(i);
								int x = vn.x;
								int y = vn.y;
								if (e.isFeedback()) {
									bends.add(new AbsoluteBendpoint(x, y + vn.height));
									bends.add(new AbsoluteBendpoint(x, y));
								} else {
									bends.add(new AbsoluteBendpoint(x, y));
									bends.add(new AbsoluteBendpoint(x, y + vn.height));
								}
							}
							conn.setRoutingConstraint(bends);
						} else {
							conn.setRoutingConstraint(Collections.EMPTY_LIST);
						}
					}
				}
				
				bounds = bounds.getTranslated(offset);
				part.getFigure().setBounds(bounds);
			}
		}
	}

}
