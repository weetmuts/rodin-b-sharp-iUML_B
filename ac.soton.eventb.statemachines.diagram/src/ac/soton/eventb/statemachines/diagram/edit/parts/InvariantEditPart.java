/*
 * Copyright (c) 2010 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.statemachines.diagram.edit.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.WrappingLabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2;
import org.eclipse.gmf.tooling.runtime.draw2d.labels.SimpleLabelDelegate;
import org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eventb.emf.core.machine.Invariant;
import org.rodinp.keyboard.ui.RodinKeyboardUIPlugin;
import org.rodinp.keyboard.ui.preferences.PreferenceConstants;

import ac.soton.eventb.statemachines.State;
import ac.soton.eventb.statemachines.diagram.edit.policies.InvariantItemSemanticEditPolicy;
import ac.soton.eventb.statemachines.diagram.edit.policies.StatemachinesTextNonResizableEditPolicy;
import ac.soton.eventb.statemachines.diagram.edit.policies.StatemachinesTextSelectionEditPolicy;
import ac.soton.eventb.statemachines.diagram.part.StatemachinesVisualIDRegistry;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesElementTypes;
import ac.soton.eventb.statemachines.diagram.providers.StatemachinesParserProvider;

/**
 * @generated
 */
public class InvariantEditPart extends CompartmentEditPart implements
		ITextAwareEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3014;

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	private IParser parser;

	/**
	 * @generated
	 */
	private List<?> parserElements;

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * @generated
	 */
	private ILabelDelegate labelDelegate;

	/**
	 * @generated
	 */
	public InvariantEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public DragTracker getDragTracker(Request request) {
		if (request instanceof SelectionRequest
				&& ((SelectionRequest) request).getLastButtonPressed() == 3) {
			return null;
		}
		return new DragEditPartsTrackerEx(this);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InvariantItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new StatemachinesTextNonResizableEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
	}

	/**
	 * @generated
	 */
	protected String getLabelTextHelper(IFigure figure) {
		if (figure instanceof WrappingLabel) {
			return ((WrappingLabel) figure).getText();
		} else if (figure instanceof Label) {
			return ((Label) figure).getText();
		} else {
			return getLabelDelegate().getText();
		}
	}

	/**
	 * @generated
	 */
	protected void setLabelTextHelper(IFigure figure, String text) {
		if (figure instanceof WrappingLabel) {
			((WrappingLabel) figure).setText(text);
		} else if (figure instanceof Label) {
			((Label) figure).setText(text);
		} else {
			getLabelDelegate().setText(text);
		}
	}

	/**
	 * @generated
	 */
	protected Image getLabelIconHelper(IFigure figure) {
		if (figure instanceof WrappingLabel) {
			return ((WrappingLabel) figure).getIcon();
		} else if (figure instanceof Label) {
			return ((Label) figure).getIcon();
		} else {
			return getLabelDelegate().getIcon(0);
		}
	}

	/**
	 * @generated
	 */
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if (figure instanceof WrappingLabel) {
			((WrappingLabel) figure).setIcon(icon);
			return;
		} else if (figure instanceof Label) {
			((Label) figure).setIcon(icon);
			return;
		} else {
			getLabelDelegate().setIcon(icon, 0);
		}
	}

	/**
	 * @generated
	 */
	public void setLabel(IFigure figure) {
		unregisterVisuals();
		setFigure(figure);
		defaultText = getLabelTextHelper(figure);
		registerVisuals();
		refreshVisuals();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getParserElement() {
		return resolveSemanticElement();
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon() {
		EObject parserElement = getParserElement();
		if (parserElement == null) {
			return null;
		}
		return StatemachinesElementTypes.getImage(parserElement.eClass());
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if (parserElement != null && getParser() != null) {
			text = getParser().getPrintString(
					new EObjectAdapter(parserElement),
					getParserOptions().intValue());
		}
		if (text == null || text.length() == 0) {
			text = defaultText;
		}
		return text;
	}

	/**
	 * @generated
	 */
	public void setLabelText(String text) {
		setLabelTextHelper(getFigure(), text);
		refreshSelectionFeedback();
	}

	/**
	 * @generated
	 */
	public String getEditText() {
		if (getParserElement() == null || getParser() == null) {
			return ""; //$NON-NLS-1$
		}
		return getParser().getEditString(
				new EObjectAdapter(getParserElement()),
				getParserOptions().intValue());
	}

	/**
	 * @generated
	 */
	protected boolean isEditable() {
		return getParser() != null;
	}

	/**
	 * @generated
	 */
	public ICellEditorValidator getEditTextValidator() {
		return new ICellEditorValidator() {

			public String isValid(final Object value) {
				if (value instanceof String) {
					final EObject element = getParserElement();
					final IParser parser = getParser();
					try {
						IParserEditStatus valid = (IParserEditStatus) getEditingDomain()
								.runExclusive(
										new RunnableWithResult.Impl<IParserEditStatus>() {

											public void run() {
												setResult(parser
														.isValidEditString(
																new EObjectAdapter(
																		element),
																(String) value));
											}
										});
						return valid.getCode() == ParserEditStatus.EDITABLE ? null
								: valid.getMessage();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}

				// shouldn't get here
				return null;
			}
		};
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor() {
		if (getParserElement() == null || getParser() == null) {
			return null;
		}
		return getParser().getCompletionProcessor(
				new EObjectAdapter(getParserElement()));
	}

	/**
	 * @generated
	 */
	public ParserOptions getParserOptions() {
		return ParserOptions.NONE;
	}

	/**
	 * @generated
	 */
	public IParser getParser() {
		if (parser == null) {
			parser = StatemachinesParserProvider
					.getParser(
							StatemachinesElementTypes.Invariant_3014,
							getParserElement(),
							StatemachinesVisualIDRegistry
									.getType(ac.soton.eventb.statemachines.diagram.edit.parts.InvariantEditPart.VISUAL_ID));
		}
		return parser;
	}

	/**
	 * @generated NOT
	 */
	protected DirectEditManager getManager() {
		if (manager == null) {
			setManager(new TextDirectEditManager(this, null,
					StatemachinesEditPartFactory.getTextCellEditorLocator(this)) {

				//+++ overriden to use Rodin math font and keyboard listener
				@Override
				protected void initCellEditor() {
					super.initCellEditor();
					Text text = (Text) getCellEditor().getControl();
					Font font = JFaceResources
							.getFont(PreferenceConstants.RODIN_MATH_FONT);
					text.setFont(font);
					ModifyListener eventBListener = RodinKeyboardUIPlugin
							.getDefault().createRodinModifyListener();
					text.addModifyListener(eventBListener);
				}
				//---

			});
		}
		return manager;
	}

	/**
	 * @generated
	 */
	protected void setManager(DirectEditManager manager) {
		this.manager = manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		getManager().show();
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit(Point eventLocation) {
		if (getManager().getClass() == TextDirectEditManager.class) {
			((TextDirectEditManager) getManager()).show(eventLocation
					.getSWTPoint());
		}
	}

	/**
	 * @generated
	 */
	private void performDirectEdit(char initialCharacter) {
		if (getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager) getManager()).show(initialCharacter);
		} else //
		{
			performDirectEdit();
		}
	}

	/**
	 * @generated
	 */
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive() && isEditable()) {
						if (theRequest
								.getExtendedData()
								.get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character) theRequest
									.getExtendedData()
									.get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
						} else if ((theRequest instanceof DirectEditRequest)
								&& (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest) theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshUnderline();
		refreshStrikeThrough();
	}

	/**
	 * @generated
	 */
	protected void refreshLabel() {
		setLabelTextHelper(getFigure(), getLabelText());
		setLabelIconHelper(getFigure(), getLabelIcon());
		refreshSelectionFeedback();
	}

	/**
	 * @generated
	 */
	protected void refreshUnderline() {
		FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
		}
	}

	/**
	 * @generated
	 */
	protected void refreshStrikeThrough() {
		FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		if (style != null && getFigure() instanceof WrappingLabel) {
			((WrappingLabel) getFigure()).setTextStrikeThrough(style
					.isStrikeThrough());
		}
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
		if (style != null) {
			FontData fontData = new FontData(style.getFontName(),
					style.getFontHeight(), (style.isBold() ? SWT.BOLD
							: SWT.NORMAL)
							| (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	/**
	 * @generated
	 */
	private void refreshSelectionFeedback() {
		requestEditPolicyFeedbackRefresh(EditPolicy.PRIMARY_DRAG_ROLE);
		requestEditPolicyFeedbackRefresh(EditPolicy.SELECTION_FEEDBACK_ROLE);
	}

	/**
	 * @generated
	 */
	private void requestEditPolicyFeedbackRefresh(String editPolicyKey) {
		Object editPolicy = getEditPolicy(editPolicyKey);
		if (editPolicy instanceof IRefreshableFeedbackEditPolicy) {
			((IRefreshableFeedbackEditPolicy) editPolicy).refreshFeedback();
		}
	}

	/**
	 * @generated
	 */
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	/**
	 * @generated
	 */
	protected void addSemanticListeners() {
		if (getParser() instanceof ISemanticParser) {
			EObject element = resolveSemanticElement();
			parserElements = ((ISemanticParser) getParser())
					.getSemanticElementsBeingParsed(element);
			for (int i = 0; i < parserElements.size(); i++) {
				addListenerFilter(
						"SemanticModel" + i, this, (EObject) parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}

	/**
	 * @generated
	 */
	protected void removeSemanticListeners() {
		if (parserElements != null) {
			for (int i = 0; i < parserElements.size(); i++) {
				removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
			}
		} else {
			super.removeSemanticListeners();
		}
	}

	/**
	 * @generated
	 */
	protected AccessibleEditPart getAccessibleEditPart() {
		if (accessibleEP == null) {
			accessibleEP = new AccessibleGraphicalEditPart() {

				public void getName(AccessibleEvent e) {
					e.result = getLabelTextHelper(getFigure());
				}
			};
		}
		return accessibleEP;
	}

	/**
	 * @generated
	 */
	private View getFontStyleOwnerView() {
		return getPrimaryView();
	}

	/**
	 * @generated
	 */
	private ILabelDelegate getLabelDelegate() {
		if (labelDelegate == null) {
			IFigure label = getFigure();
			if (label instanceof WrappingLabel) {
				labelDelegate = new WrappingLabelDelegate((WrappingLabel) label);
			} else {
				labelDelegate = new SimpleLabelDelegate((Label) label);
			}
		}
		return labelDelegate;
	}

	/**
	 * @generated
	 */
	@Override
	public Object getAdapter(Class key) {
		if (ILabelDelegate.class.equals(key)) {
			return getLabelDelegate();
		}
		return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("PrimaryView"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer) event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(
				feature)) {
			refreshUnderline();
		} else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough()
				.equals(feature)) {
			refreshStrikeThrough();
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(
				feature)
				|| NotationPackage.eINSTANCE.getFontStyle_FontName().equals(
						feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Bold()
						.equals(feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Italic().equals(
						feature)) {
			refreshFont();
		} else {
			if (getParser() != null
					&& getParser().isAffectingEvent(event,
							getParserOptions().intValue())) {
				refreshLabel();
			}
			if (getParser() instanceof ISemanticParser) {
				ISemanticParser modelParser = (ISemanticParser) getParser();
				if (modelParser.areSemanticElementsAffected(null, event)) {
					removeSemanticListeners();
					if (resolveSemanticElement() != null) {
						addSemanticListeners();
					}
					refreshLabel();
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		IFigure label = createFigurePrim();
		defaultText = getLabelTextHelper(label);
		return label;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigurePrim() {
		return new WrappingLabel();
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isSelectable() {
		return getFigure().isShowing();
	}

	/////////// mouse-over feedback text ///////////	
	Label feedbackFigure = null;
	String feedbackText = null;;

	/*
	 * Provides mouse over feedback:
	 * Customised to  show the contents of the invariant
	 * @custom
	 */
	@Override
	public void showTargetFeedback(Request request) {
		super.showTargetFeedback(request);
		// the feedback layer figures do not receive mouse e
		if (feedbackText == null) {
			feedbackText = getMethodText();
			if (feedbackText.length() > 0) {
				feedbackFigure = new Label(feedbackText);
				feedbackFigure.setFont(new Font(null, "Arial", 12, SWT.NORMAL));
				Rectangle bounds = feedbackFigure.getTextBounds().getCopy()
						.expand(10, 10);
				Point location = getFigure().getBounds().getLocation()
						.translate(50, 0);
				getFigure().translateToAbsolute(location);
				bounds.setLocation(location);
				feedbackFigure.setBounds(bounds);
				feedbackFigure.setForegroundColor(ColorConstants.darkGreen); //tooltipForeground);
				feedbackFigure.setBackgroundColor(ColorConstants.lightGray); //tooltipBackground);
				feedbackFigure.setOpaque(true);
				//feedbackFigure.setBorder(new LineBorder());
				IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
				layer.add(feedbackFigure);
			}
		}
	}

	private String getMethodText() {
		Invariant invariant = (Invariant) resolveSemanticElement();
		if (((State) invariant.eContainer()).getActiveInstances() != null)
			return ""; //no feedback while animating
		String text = invariant.getName()
				+ (invariant.isTheorem() ? "(THEOREM) :\n" : " :\n");
		text = text + indent(1, "", invariant.getPredicate());
		if (invariant.getComment() != null
				&& invariant.getComment().length() > 0) {
			text = text + "\n" + indent(2, "//", invariant.getComment());
		}
		return text;
	}

	private static String indent(int tabs, String prefix, String text) {
		if (text == null || text.length() < 1)
			return "";
		String indent = "";
		for (int i = 0; i < tabs; i++) {
			indent = indent + "\t";
		}
		indent = indent + prefix;
		return indent + text.replace("\n", "\n" + indent);
	}

	/* Erases mouse-over feedback.
	 * @custom
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		if (request instanceof CreateConnectionRequest)
			return;
		if (getViewer() == null)
			return;
		IFigure layer = getLayer(LayerConstants.FEEDBACK_LAYER);
		if (layer != null && feedbackFigure != null
				&& feedbackFigure.getParent() != null) {
			layer.remove(feedbackFigure);
		}
		feedbackFigure = null;
		feedbackText = null;
	}

}
