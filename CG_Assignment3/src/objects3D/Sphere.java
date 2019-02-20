package objects3D;

import org.lwjgl.opengl.GL11;

public class Sphere {

	
	public Sphere() {

	}
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	// 7b should be your primary source, we will cover more about circles in later lectures to understand why the code works 
	public void DrawSphere(float radius,float nSlices,float nSegments) {
		GL11.glBegin(GL11.GL_QUADS);				
				float inctheta =(float) ((1.0f*Math.PI)/nSlices);
				float incphi =(float) (Math.PI/nSegments); 
				for(float theta=(float) -Math.PI; theta<Math.PI; theta+=inctheta)
				{
					for(float phi=(float) -(Math.PI); phi<(Math.PI); phi+=incphi)
				{
					float x = (float) (radius * Math.cos(phi) * Math.cos(theta));
					float y = (float) (radius * Math.cos(phi) * Math.sin(theta));
					float z = (float) (radius * Math.sin(phi));
					//+incphi
					float x1 = (float) (radius * Math.cos(phi+incphi) * Math.cos(theta));
					float y1 = (float) (radius * Math.cos(phi+incphi) * Math.sin(theta));
					float z1 = (float) (radius * Math.sin(phi+incphi));
					//+incphi,+inctheta
					float x2 = (float) (radius * Math.cos(phi+incphi) * Math.cos(theta+inctheta));
					float y2 = (float) (radius * Math.cos(phi+incphi) * Math.sin(theta+inctheta));
					float z2 = (float) (radius * Math.sin(phi+incphi));
					//+inctheta
					float x3 = (float) (radius * Math.cos(phi) * Math.cos(theta+inctheta));
					float y3 = (float) (radius * Math.cos(phi) * Math.sin(theta+inctheta));
					float z3 = (float) (radius * Math.sin(phi));
					
					//only these(x,y,z) can draw a Sphere but not empty	
					GL11.glNormal3f(x, y, z);
					GL11.glVertex3f(x, y, z);
					
					GL11.glNormal3f(x1, y1, z1);
					GL11.glVertex3f(x1, y1, z1);
				
					GL11.glNormal3f(x2, y2, z2);
					GL11.glVertex3f(x2, y2, z2);
					
					GL11.glNormal3f(x3, y3, z3);
					GL11.glVertex3f(x3, y3, z3);
					
				}
				}
				GL11.glEnd();
			}
}

 