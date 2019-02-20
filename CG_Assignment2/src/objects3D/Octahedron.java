package objects3D;


import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Octahedron {

	
	public Octahedron()
	{
		
	}
	
	
	// Implement using notes and examine Tetrahedron to aid in the coding  look at lecture  7 , 7b and 8 
	public void DrawOctahedron()
	{
		Point4f[] vertices={new Point4f(1.0f, 0.0f, 0.0f,0.0f),
			 	new Point4f(-1.0f, 0.0f, 0.0f,0.0f),
			 	new Point4f(0.0f, 1.0f, 0.0f,0.0f),
			 	new Point4f(0.0f, -1.0f, 0.0f,0.0f),
			 	new Point4f(0.0f, 0.0f, 1.0f,0.0f),
			 	new Point4f(0.0f, 0.0f, -1.0f,0.0f)};
				//these are point
				int triangles[][]={
						{ 4, 0, 2},
						{ 4, 2, 1},
						{ 4, 1, 3},
						{ 4, 3, 0},
						{ 1, 2, 5},
						{ 0, 5, 2},
						{ 3, 5, 0},
						{ 1, 5, 3}};
				GL11.glBegin(GL11.GL_TRIANGLES);
				for (int face = 0; face < 8; face++) { // per face
					Vector4f v = vertices[triangles[face][1]].MinusPoint(vertices[triangles[face][0]]); 
					Vector4f w = vertices[triangles[face][2]].MinusPoint(vertices[triangles[face][0]]);
					Vector4f normal = v.cross(w).Normal();		
					GL11.glNormal3f(normal.x, normal.y, normal.z);
					GL11.glVertex3f(vertices[triangles[face][0]].x, vertices[triangles[face][0]].y, vertices[triangles[face][0]].z);
					GL11.glVertex3f(vertices[triangles[face][1]].x, vertices[triangles[face][1]].y, vertices[triangles[face][1]].z);
					GL11.glVertex3f(vertices[triangles[face][2]].x, vertices[triangles[face][2]].y, vertices[triangles[face][2]].z);
				} // per face
				GL11.glEnd();
	}
}
 