package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Utils;

public class barrier {
	// basic colours
	static float black[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	static float white[] = { 1.0f, 1.0f, 1.0f, 1.0f };

	static float grey[] = { 0.5f, 0.5f, 0.5f, 1.0f };
	static float spot[] = { 0.1f, 0.1f, 0.1f, 0.5f };

	// primary colours
	static float red[] = { 1.0f, 0.0f, 0.0f, 1.0f };
	static float green[] = { 0.0f, 1.0f, 0.0f, 1.0f };
	static float blue[] = { 0.0f, 0.0f, 1.0f, 1.0f };

	// secondary colours
	static float yellow[] = { 1.0f, 1.0f, 0.0f, 1.0f };
	static float magenta[] = { 1.0f, 0.0f, 1.0f, 1.0f };
	static float cyan[] = { 0.0f, 1.0f, 1.0f, 1.0f };

	// other colours
	static float orange[] = { 1.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float brown[] = { 0.5f, 0.25f, 0.0f, 1.0f, 1.0f };
	static float dkgreen[] = { 0.0f, 0.5f, 0.0f, 1.0f, 1.0f };
	static float pink[] = { 1.0f, 0.6f, 0.6f, 1.0f, 1.0f };
	
	
	public barrier() {

	}
	
	// Implement using notes  in Animation lecture  
	public void Drawbarrier() 
 { 
		
		 
		  
		Cylinder cylinder= new Cylinder();
		GL11.glColor3f(red[0], red[1], red[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(-5.1f,-1.0f+1.5f,-2f+2f);
             //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
             GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
             GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);  
             cylinder.DrawCylinder(0.2f,0.2f,32);
         } GL11.glPopMatrix();
         
	}	
}



