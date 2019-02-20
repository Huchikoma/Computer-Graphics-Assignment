package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;

public class win {

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
	
	
	public win() {

	}
	
	// Implement using notes  in Animation lecture  
	public void Drawwin() 
 { 
		
		 
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		TexSphere texSphere = new TexSphere();
		TexSphere texSphere2 = new TexSphere();
		 
	//柱子	
		GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(yellow));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(-5.1f,-1.0f+1.5f,-2f+2f);
             //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
             GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
             GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);  
             cylinder.DrawCylinder(0.05f,2f,32);
         } GL11.glPopMatrix();
         
       //柱子	
 		GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(3f,-1.0f+1.5f,-2f+2f);
              //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
              GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
              GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);  
              cylinder.DrawCylinder(0.05f,2f,32);
          } GL11.glPopMatrix();
        //柱子	
   		GL11.glColor3f(yellow[0], yellow[1], yellow[2]);
           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
            GL11.glPushMatrix(); {
                GL11.glTranslatef(3f,-1.0f+1.5f,-2f+2f);
                //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                GL11.glRotatef(0f,0.0f,1.0f,0.0f); 
                GL11.glRotatef(-90f,1.0f,0.0f,0.0f); 
                cylinder.DrawCylinder(0.05f,8.1f,32);
            } GL11.glPopMatrix();
	}	
}

