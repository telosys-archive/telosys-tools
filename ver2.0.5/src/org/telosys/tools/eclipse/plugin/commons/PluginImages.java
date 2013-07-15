package org.telosys.tools.eclipse.plugin.commons;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.telosys.tools.eclipse.plugin.MyPlugin;

public class PluginImages {

	// images keys
	public static final String TELOSYS_LOGO  = "TELOSYS_LOGO" ; 
	public static final String SAMPLE        = "SAMPLE" ; 
	
	public static final String PRIMARYKEY    = "PRIMARYKEY" ; 

	public static final String PRIMARYKEY_AUTOINCR  = "PRIMARYKEY_AUTOINCR" ;  // v 1.0
	public static final String PRIMARYKEY_FK        = "PRIMARYKEY_FK" ;  // v 1.0
	
	public static final String FOREIGNKEY    = "FOREIGNKEY" ; // v 1.0 
	public static final String JOINTABLE     = "JOINTABLE" ; // v 1.0 
	
	public static final String ARROW_RIGHT   = "ARROW_RIGHT" ; // v 1.0 
	public static final String ARROW_LEFT    = "ARROW_LEFT" ; // v 1.0 
	
	public static final String NOTNULL_ON    = "NOTNULL_ON" ; 
	public static final String NOTNULL_OFF   = "NOTNULL_OFF" ; 
	
	public static final String LINK_MANY_TO_ONE   = "LINK_MANY_TO_ONE" ; 
	
	public static final String EDIT_ICON   = "EDIT_ICON" ; // v 2.0
	public static final String GENERATE    = "GENERATE" ; // v 2.0
	public static final String REFRESH     = "REFRESH" ; // v 2.0
	public static final String TARGETS     = "TARGETS" ; // v 2.0

	public static final String CHECKED_ON     = "CHECKED_ON" ; // v 2.0
	public static final String CHECKED_OFF    = "CHECKED_OFF" ; // v 2.0

	// Images for Velocity Templates Editor  ( v 2.0.5 )
	public static final String VELOCITY_BEAN_GENERATOR = "VELOCITY_BEAN_GENERATOR";
	public static final String VELOCITY_BEAN_METHOD = "VELOCITY_BEAN_METHOD";
	public static final String VELOCITY_BEAN_PROPERTY = "VELOCITY_BEAN_PROPERTY";
	public static final String VELOCITY_DIRECTIVE = "VELOCITY_DIRECTIVE";
	public static final String VELOCITY_PREDEF_VARIABLE = "VELOCITY_PREDEF_VARIABLE";
	public static final String VELOCITY_PREDEFNAMES = "VELOCITY_PREDEFNAMES";
	
	// images registry
	private static ImageRegistry $imageRegistry = new ImageRegistry() ;

    //------------------------------------------------------------------------------------------------
	/**
	 * Register the given image with the given key
	 * @param sImgKey
	 * @param sImgFile
	 * @return
	 */
	private static ImageDescriptor registerImage(String sImgKey, String sImgFile) 
	{
		URL url = MyPlugin.getImageURL(sImgFile);
		if ( url != null )
		{
			$imageRegistry.put(sImgKey, ImageDescriptor.createFromURL(url) );			
		}
		return ImageDescriptor.createFromURL(url);
	}
	
    //------------------------------------------------------------------------------------------------
	// Init the registry
	static {
		registerImage(TELOSYS_LOGO, Const.TELOSYS_IMAGE ) ;
		//registerImage(SAMPLE, Const.SAMPLE_IMAGE ) ;
		registerImage(PRIMARYKEY,  Const.PRIMARYKEY_IMAGE ) ;
		
		registerImage(PRIMARYKEY_AUTOINCR,  Const.PRIMARYKEY_AUTOINCR_IMAGE ) ;  // v 1.0
		registerImage(PRIMARYKEY_FK,        Const.PRIMARYKEY_FK_IMAGE ) ;  // v 1.0

		registerImage(FOREIGNKEY,  Const.FOREIGNKEY_IMAGE ) ;  // v 1.0
		registerImage(JOINTABLE,   Const.JOINTABLE_IMAGE ) ;  // v 1.0

		registerImage(ARROW_RIGHT,  Const.ARROW_RIGHT_IMAGE ) ;  // v 1.0
		registerImage(ARROW_LEFT,   Const.ARROW_LEFT_IMAGE ) ;  // v 1.0
		
		registerImage(NOTNULL_ON,  Const.NOTNULL_ON_IMAGE ) ;
		registerImage(NOTNULL_OFF, Const.NOTNULL_OFF_IMAGE ) ;
		
		registerImage(LINK_MANY_TO_ONE, Const.LINK_MANY_TO_ONE_IMAGE );

		registerImage(EDIT_ICON,    Const.EDIT_ICON );
		registerImage(GENERATE,     Const.GENERATE );
		registerImage(REFRESH,      Const.REFRESH );
		registerImage(TARGETS,      Const.TARGETS );
		registerImage(CHECKED_OFF,  Const.CHECKED_OFF );
		registerImage(CHECKED_ON,   Const.CHECKED_ON );
		
		// Velocity Templates Editor ( v 2.0.5 )
		registerImage(VELOCITY_BEAN_GENERATOR,   Const.VELOCITY_BEAN_GENERATOR_IMAGE );
		registerImage(VELOCITY_BEAN_METHOD,      Const.VELOCITY_BEAN_METHOD_IMAGE );
		registerImage(VELOCITY_BEAN_PROPERTY,    Const.VELOCITY_BEAN_PROPERTY_IMAGE );
		registerImage(VELOCITY_DIRECTIVE,        Const.VELOCITY_DIRECTIVE_IMAGE );
		registerImage(VELOCITY_PREDEF_VARIABLE,  Const.VELOCITY_PREDEF_VARIABLE_IMAGE);
		registerImage(VELOCITY_PREDEFNAMES,      Const.VELOCITY_PREDEFNAMES_IMAGE);
		
	}

    //------------------------------------------------------------------------------------------------
	/**
	 * Returns the image descriptor registered with the given key
	 * @param sImgKey
	 * @return
	 */
	public static ImageDescriptor getImageDescriptor(String sImgKey) 
	{
		return $imageRegistry.getDescriptor(sImgKey);
	}

    //------------------------------------------------------------------------------------------------
	/**
	 * Returns the image registered with the given key
	 * @param sImgKey
	 * @return
	 */
	public static Image getImage(String sImgKey) 
	{
		//return $imageRegistry.get(sImgKey);
		ImageDescriptor imgDesc = getImageDescriptor(sImgKey) ;
		if ( imgDesc != null )
		{
			return imgDesc.createImage();
		}
		else
		{
			MsgBox.error("Cannot get image descriptor for key '" + sImgKey + "'");
			return null ;
		}
	}

}
