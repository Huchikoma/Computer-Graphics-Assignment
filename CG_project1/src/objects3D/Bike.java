package objects3D;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;

import GraphicsObjects.Point4f;
import GraphicsObjects.Utils;
import GraphicsObjects.Vector4f;

public class Bike {

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
	
	
	public Bike() {

	}
	
	// Implement using notes  in Animation lecture  
	public void DrawBike(float delta,Texture myTexture,Texture myTexture2) 
 { 
		
		 float theta = (float) (delta * 2 * Math.PI);
		 float LimbRotation;
		 
			 LimbRotation = (float) Math.cos(theta)*45;
		
		 float LimbRotation2;
		
			 LimbRotation2 = (float) (Math.tan(theta*1000)*1.6);
		 
		  
		Sphere sphere= new Sphere();
		Cylinder cylinder= new Cylinder();
		TexSphere texSphere = new TexSphere();
		TexSphere texSphere2 = new TexSphere();
		 
		//right
		//Chain
		GL11.glColor3f(black[0], black[1], black[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(0.0f,-1.0f-0.3f,-2f+2.0f);
             GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
             GL11.glRotatef(7.0f,0.0f,1.0f,0.0f);
            // GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); //make  joints move only in certain angles
          //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
             cylinder.DrawCylinder(0.02f,1.1f,32);
         } GL11.glPopMatrix();
         GL11.glColor3f(black[0], black[1], black[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(0.0f,-1.0f+0.3f,-2f+2.0f);
              GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
              GL11.glRotatef(360f-7f,0.0f,1.0f,0.0f);
             // GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); //make  joints move only in certain angles
           //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
              cylinder.DrawCylinder(0.02f,1.1f,32);
          } GL11.glPopMatrix();
		//front wheel
		GL11.glColor3f(white[0], white[1], white[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(0.001f,-1.0f,-2f+0.4f);
             GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
             GL11.glRotatef(LimbRotation2,0.0f,1.0f,0.0f);
             cylinder.DrawCylinder(0.7f,0.1f,32);
         }GL11.glPopMatrix();
		//front wheel
		GL11.glColor3f(orange[0], orange[1], orange[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(0.2f,-1.0f,-2f+2f);
             GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
             GL11.glRotatef(-LimbRotation*2,0.0f,1.0f,0.0f); //make  joints move only in certain angles
          //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
             cylinder.DrawCylinder(0.05f,0.4f,32);
         } GL11.glPopMatrix();
       //cranks 
 		GL11.glColor3f(orange[0], orange[1], orange[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(-0.1f,-1.0f,-2f+2f);
              GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
              GL11.glRotatef(LimbRotation*2,0.0f,1.0f,0.0f); //make  joints move only in certain angles
           //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
              cylinder.DrawCylinder(0.05f,0.4f,32);
          } GL11.glPopMatrix();
		//Free wheel 
		GL11.glColor3f(black[0], black[1], black[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(0.01f,-1.0f,-2f+3f);
             GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
             cylinder.DrawCylinder(0.2f,0.1f,32);
         } GL11.glPopMatrix();
		//crank
		GL11.glColor3f(black[0], black[1], black[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(-0.15f,-1.0f,-2f+2f);
             GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
             cylinder.DrawCylinder(0.3f,0.1f,32);
         } GL11.glPopMatrix();
		 //front wheel
		 GL11.glColor3f(black[0], black[1], black[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(0.0f,-1.0f,-2f+0.4f);
              GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
              
              cylinder.DrawCylinder(0.8f,0.1f,32);
          }
        //back wheel
 		 GL11.glPopMatrix();
 		 GL11.glColor3f(black[0], black[1], black[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(0.0f,-1.0f,-2f+3.0f);
              GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
              
              cylinder.DrawCylinder(0.8f,0.1f,32);
          }
 		 GL11.glPopMatrix();
 		 //Chain stay
 		GL11.glColor3f(pink[0], pink[1], pink[2]);
        GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
         GL11.glPushMatrix(); {
             GL11.glTranslatef(0.0f,-1.0f,-2f+2f);
             GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
            // GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); //make  joints move only in certain angles
          //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
             cylinder.DrawCylinder(0.05f,1.0f,32);
         } GL11.glPopMatrix();
       //top stay
         GL11.glColor3f(pink[0], pink[1], pink[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(0.0f,-1.0f+0.9f,-2f+2f);
              //GL11.glTranslatef(0.0f,0.0+上-下,2f+前-后);
              GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
              GL11.glRotatef(-40.0f,0.0f,1.0f,0.0f);
             // GL11.glRotatef(LimbRotation,1.0f,0.0f,0.0f); //make  joints move only in certain angles
           //   GL11.glRotatef(27.5f,0.0f,1.0f,0.0f);  
              cylinder.DrawCylinder(0.05f,1.3f,32);
          } GL11.glPopMatrix();
         //Down tube
          GL11.glColor3f(pink[0], pink[1], pink[2]);
         GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
          GL11.glPushMatrix(); {
              GL11.glTranslatef(0.0f,-1.0f+0.74f,-2f+0.7f);
              GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
              GL11.glRotatef(-30.0f,0.0f,1.0f,0.0f);
              cylinder.DrawCylinder(0.05f,1.5f,32);
          } GL11.glPopMatrix();
 		 //seat tube
          GL11.glColor3f(pink[0], pink[1], pink[2]);
          GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
           GL11.glPushMatrix(); {
               GL11.glTranslatef(0.0f,-1.0f+1.5f,-2f+2f);
               //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
               GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
               GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);
           } GL11.glPopMatrix();
        
         //top tube
           GL11.glColor3f(pink[0], pink[1], pink[2]);
           GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
            GL11.glPushMatrix(); {
                GL11.glTranslatef(0.0f,-1.0f+0.9f,-2f+0.7f);
                //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                cylinder.DrawCylinder(0.05f,1.3f,32);
            } GL11.glPopMatrix();
          
            //fork
            GL11.glColor3f(pink[0], pink[1], pink[2]);
            GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
             GL11.glPushMatrix(); {
                 GL11.glTranslatef(0.0f,-1.0f,-2f+0.4f);
                 //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                 GL11.glRotatef(90.0f,0.0f,-0.3f,1.0f);
                 GL11.glRotatef(85.0f,0.0f,1.0f,0.0f);
                 cylinder.DrawCylinder(0.05f,0.73f,32);
             } GL11.glPopMatrix();
             
          //head tube
             GL11.glColor3f(pink[0], pink[1], pink[2]);
             GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
              GL11.glPushMatrix(); {
                  GL11.glTranslatef(0.05f,-1.0f+1f,-2f+0.75f);
                  //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                  GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                  GL11.glRotatef(-100.0f,0.0f,1.0f,0.0f);
                  cylinder.DrawCylinder(0.1f,0.35f,32);
              } GL11.glPopMatrix();
              //handle bar
              GL11.glColor3f(pink[0], pink[1], pink[2]);
              GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
               GL11.glPushMatrix(); {
                   GL11.glTranslatef(-0.75f,-1.0f+1.2f,-2f+0.75f);
                   //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                   GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                   GL11.glRotatef(LimbRotation/20,0.0f,1.0f,0.0f);
                   cylinder.DrawCylinder(0.06f,1.5f,32);
               } GL11.glPopMatrix();
              //stem
               GL11.glColor3f(pink[0], pink[1], pink[2]);
               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                GL11.glPushMatrix(); {
                    GL11.glTranslatef(0.05f,-1.0f+1.2f,-2f+0.75f);
                    //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                    GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                    GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);
                    cylinder.DrawCylinder(0.1f,0.35f,32);
                } GL11.glPopMatrix();
               
               
                
                //left
        		 //Chain stay
                GL11.glColor3f(pink[0], pink[1], pink[2]);
               GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                GL11.glPushMatrix(); {
                    GL11.glTranslatef(0.1f,-1.0f,-2f+2f);
                    GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                    cylinder.DrawCylinder(0.05f,1.0f,32);
                } GL11.glPopMatrix();
              //top stay
                GL11.glColor3f(pink[0], pink[1], pink[2]);
                GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                 GL11.glPushMatrix(); {
                     GL11.glTranslatef(0.1f,-1.0f+0.9f,-2f+2f);
                     //GL11.glTranslatef(0.0f,0.0+上-下,2f+前-后);
                     GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                     GL11.glRotatef(-40.0f,0.0f,1.0f,0.0f); 
                     cylinder.DrawCylinder(0.05f,1.3f,32);
                 } GL11.glPopMatrix();
                //down tube
                 GL11.glColor3f(pink[0], pink[1], pink[2]);
                GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                 GL11.glPushMatrix(); {
                     GL11.glTranslatef(0.1f,-1.0f+0.74f,-2f+0.7f);
                     GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                     GL11.glRotatef(-30.0f,0.0f,1.0f,0.0f);
                     cylinder.DrawCylinder(0.05f,1.5f,32);
                 } GL11.glPopMatrix();
        		 //Seat tube
                 GL11.glColor3f(pink[0], pink[1], pink[2]);
                 GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                  GL11.glPushMatrix(); {
                      GL11.glTranslatef(0.1f,-1.0f+1.5f,-2f+2f);
                      //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                      GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                      GL11.glRotatef(-90.0f,0.0f,1.0f,0.0f);  
                      cylinder.DrawCylinder(0.05f,1.5f,32);
                  } GL11.glPopMatrix();
               
                //top tube
                  GL11.glColor3f(pink[0], pink[1], pink[2]);
                  GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                   GL11.glPushMatrix(); {
                       GL11.glTranslatef(0.1f,-1.0f+0.9f,-2f+0.7f);
                       //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                       GL11.glRotatef(90.0f,0.0f,0.0f,1.0f);
                       cylinder.DrawCylinder(0.05f,1.3f,32);
                   } GL11.glPopMatrix();
                 
                   //fork
                   GL11.glColor3f(pink[0], pink[1], pink[2]);
                   GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                    GL11.glPushMatrix(); {
                        GL11.glTranslatef(0.1f,-1.0f,-2f+0.4f);
                        //GL11.glTranslatef(0.0f,0.0+上-下,2f-前+后);
                        GL11.glRotatef(90.0f,0.0f,-0.3f,1.0f);
                        GL11.glRotatef(85.0f,0.0f,1.0f,0.0f);
                        cylinder.DrawCylinder(0.05f,0.73f,32);
                       GL11.glPopMatrix();
                       //back wheel
            		 GL11.glColor3f(white[0], white[1], white[2]);
                    GL11.glMaterial( GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE,  Utils.ConvertForGL(orange));
                     GL11.glPushMatrix(); {
                         GL11.glTranslatef(0.001f,-1.0f,-2f+3.0f);
                         GL11.glRotatef(90.0f,0.0f,1.0f,0.0f);
                         GL11.glRotatef(LimbRotation2,0.0f,1.0f,0.0f);
                         cylinder.DrawCylinder(0.7f,0.1f,32);
                     }  
                    } GL11.glPopMatrix();
                   
                
	}	
}
