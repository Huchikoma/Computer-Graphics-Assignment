package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class Cylinder {

	
	public Cylinder() { 
	}
	
	// remember to use Math.PI isntead PI 
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCylinder(float radius, float height, int nSegments ) 
	{

		GL11.glBegin(GL11.GL_TRIANGLES);
		 for(float i = (float) 0.0; i < nSegments; i += 1.0){
			 float angle = (float) ( Math.PI * i * 2.0/ nSegments) ;
			 
			 float nextAngle = (float) (Math.PI * (i + 1.0) * 2.0 / nSegments);
		 
			 float x1 = (float) Math.sin(angle)*radius,y1=(float) Math.cos(angle)*radius;
			 
			 float x2 = (float) Math.sin(nextAngle)*radius,y2=(float) Math.cos(nextAngle)*radius;
		
			 Point4f vertices[]={
						new Point4f(x1,y1,height,0.0f),
						new Point4f(x2,y2,0.0f,0.0f),
						new Point4f(x1,y1,0.0f,0.0f),
				 		new Point4f(x2,y2,height,0.0f),
				 		new Point4f(0.0f,0.0f,height,0.0f),
				 		new Point4f(0.0f,0.0f,height,0.0f)
					};
			 Point4f Normal[]={
					new Point4f(x1,y1,0.0f,0.0f),
					new Point4f(x2,y2,0.0f,0.0f),
					new Point4f(x1,y1,0.0f,0.0f),
				 	new Point4f(x2,y2,0.0f,0.0f),
				 	new Point4f(0.0f,0.0f,0.0f,0.0f),
				 	new Point4f(0.0f,0.0f,0.0f,0.0f)
			 };
			//these are point
		     int triangles[][] = {{0,1,2},{0,3,1},{1,2,5},{0,3,4}};//the last two point are top and lower point
		     
				for (int face = 0; face < 4; face++) { // per face
					Vector4f v = vertices[triangles[face][1]].MinusPoint(vertices[triangles[face][0]]); 
					Vector4f w = vertices[triangles[face][2]].MinusPoint(vertices[triangles[face][0]]);
					Vector4f normal = v.cross(w).Normal();			
					
				 	GL11.glNormal3f(normal.x, normal.y, normal.z);
				 	
					GL11.glVertex3f(vertices[triangles[face][0]].x, vertices[triangles[face][0]].y, vertices[triangles[face][0]].z);
					GL11.glVertex3f(vertices[triangles[face][1]].x, vertices[triangles[face][1]].y, vertices[triangles[face][1]].z);
					GL11.glVertex3f(vertices[triangles[face][2]].x, vertices[triangles[face][2]].y, vertices[triangles[face][2]].z);
					
				} // per face
		 }
			GL11.glEnd();
	}
}
