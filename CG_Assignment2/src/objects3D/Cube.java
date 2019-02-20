package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {

	
	public Cube() {

	}
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawCube() 
 {
		Point4f vertices[] = { 	
				new Point4f(1.0f, 1.0f, 1.0f,0.0f), 
				new Point4f(-1.0f, 1.0f, 1.0f,0.0f),
				new Point4f(1.0f, -1.0f, 1.0f,0.0f), 
				new Point4f(-1.0f, -1.0f,1.0f,0.0f),
				new Point4f(1.0f, 1.0f, -1.0f,0.0f), 
				new Point4f(-1.0f, 1.0f,-1.0f,0.0f), 
				new Point4f(1.0f, -1.0f, -1.0f,0.0f),
				new Point4f(-1.0f,-1.0f, -1.0f,0.0f)};
		//these are point
		int triangles[][] = {
				{2, 7, 6},
				{7, 2, 3},
				{6, 7, 4},
				{7, 5, 4},
				{3, 1, 7},
				{1, 5, 7},
				{0, 2, 4},
				{4, 2, 6},
				{0, 1, 2}, 
				{2, 1, 3},
				{1, 0, 4},
				{4, 5, 1}
				};
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < 12; face++) { // per face
			Vector4f v = vertices[triangles[face][1]].MinusPoint(vertices[triangles[face][0]]); 
			Vector4f w = vertices[triangles[face][2]].MinusPoint(vertices[triangles[face][0]]);
			Vector4f normal = v.cross(w).Normal();
		 	GL11.glNormal3f(normal.x, normal.y, normal.z);
			GL11.glVertex3f(vertices[triangles[face][0]].x, vertices[triangles[face][0]].y, vertices[triangles[face][0]].z);
			GL11.glVertex3f(vertices[triangles[face][1]].x, vertices[triangles[face][1]].y, vertices[triangles[face][1]].z);
			GL11.glVertex3f(vertices[triangles[face][2]].x, vertices[triangles[face][2]].y, vertices[triangles[face][2]].z);
		} // per face
		GL11.glEnd();}
	}
	
	
	

 
	/*
	 
	 
}

	*/
	 