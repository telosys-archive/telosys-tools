package org.telosys.tools.eclipse.plugin.commons.widgets;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.telosys.tools.eclipse.plugin.commons.PluginImages;
import org.telosys.tools.eclipse.plugin.commons.TargetUtil;
import org.telosys.tools.eclipse.plugin.editors.dbrep.RepositoryEditor;

public class TargetsButton {

	private final static int  BUTTON_HEIGHT =  26 ;
	private final static int  BUTTON_WIDTH  =  74 ; //80 ;
	
	private final Button           _button ;
	private final RepositoryEditor _editor ;
	private final IProject         _project ;

	public TargetsButton(Composite parent, RepositoryEditor editor, IProject project ) {
		super();

		_editor = editor ;
		_project = project ;
		
		_button = new Button(parent, SWT.NONE);
		_button.setText("Edit");
		_button.setToolTipText("Edit targets/templates file");

		_button.setImage( PluginImages.getImage(PluginImages.TARGETS ) );
		
		_button.setLayoutData ( new GridData (BUTTON_WIDTH, BUTTON_HEIGHT) );
		
		_button.addSelectionListener( new SelectionListener() 
	    	{
	            public void widgetSelected(SelectionEvent arg0)
	            {
	            	//--- Standard behavior : open the targets/templates configuration file in text editor
	            	TargetUtil.openTargetsConfigFileInEditor(_project, _editor.getCurrentBundleName());
	            }
	            public void widgetDefaultSelected(SelectionEvent arg0)
	            {
	            }
	        });
	}
	
	public Button getButton() {
		return _button ;
	}
	
	public void setEnabled(boolean enabled) {
		_button.setEnabled(enabled);
	}
	
	public void addSelectionListener(SelectionListener listener) {
		_button.addSelectionListener( listener ) ;
	}
}