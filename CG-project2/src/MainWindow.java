
import java.io.IOException;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import GraphicsObjects.Arcball;
import GraphicsObjects.Utils;
import objects3D.Bike;
import objects3D.TexCube;
import objects3D.TexSphere;  
import objects3D.Grid;
import objects3D.Human; 
import objects3D.barrier;
import objects3D.bike1;
import objects3D.player1;
import objects3D.player2;
import objects3D.player3;
import objects3D.win;

//Main windows class controls and creates the 3D virtual world , please do not change this class but edit the other classes to complete the assignment. 
// Main window is built upon the standard Helloworld LWJGL class which I have heavily modified to use as your standard openGL environment. 
// 

// Do not touch this class, I will be making a version of it for your 3rd Assignment 
public class MainWindow {

	private  boolean MouseOnepressed = true;
	private boolean  dragMode=false;
	/** position of pointer */
	float x = 400, y = 300;
	/** angle of rotation */
	float rotation = 0;
	/** time at last frame */
	long lastFrame;
	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;
	
	long  myDelta =0 ; //to use for animation
	float Alpha =0 ; //to use for animation
	long StartTime; // beginAnimiation 

	Arcball MyArcball= new Arcball();
	
	boolean DRAWGRID =false;
	boolean waitForKeyrelease= true;
	/** Mouse movement */
	int LastMouseX = -1 ;
	int LastMouseY= -1;
	
	 float pullX = 0.0f; // arc ball  X cord. 
	 float pullY = 0.0f; // arc ball  Y cord. 

	 
	int OrthoNumber = 1200; // using this for screen size, making a window of 1200 x 800 so aspect ratio 3:2 // do not change this for assignment 3 but you can change everything for your project 
	
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

	// static GLfloat light_position[] = {0.0, 100.0, 100.0, 0.0};

	//support method to aid in converting a java float array into a Floatbuffer which is faster for the opengl layer to process 
	

	public void start() {
		
		
		StartTime = getTime();
		try {
			Display.setDisplayMode(new DisplayMode(1200, 800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		initGL(); // init OpenGL
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer
		 
		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			Display.sync(120); // cap fps to 120fps
		}

		Display.destroy();
	}

	public void update(int delta) {
		// rotate quad
		//rotation += 0.01f * delta;
		  
		  
		int MouseX= Mouse.getX();
		  int MouseY= Mouse.getY();
		  int WheelPostion = Mouse.getDWheel();
	  
		  
		  boolean  MouseButonPressed= Mouse.isButtonDown(0);
		  
		 
		  
		  if(MouseButonPressed && !MouseOnepressed )
		  {
			  MouseOnepressed =true;
			//  System.out.println("Mouse drag mode");
			  MyArcball.startBall( MouseX, MouseY, 1200, 800);
			  dragMode=true;
				
				
		  }else if( !MouseButonPressed)
		  { 
				// System.out.println("Mouse drag mode end ");
			  MouseOnepressed =false;
			  dragMode=false;
		  }
		  
		  if(dragMode)
		  {
			  MyArcball.updateBall( MouseX  , MouseY  , 1200, 800);
		  }
		  
		  if(WheelPostion>0)
		  {
			  OrthoNumber += 10;
			 
		  }
		  
		  if(WheelPostion<0)
		  {
			  OrthoNumber -= 10;
			  if( OrthoNumber<610)
			  {
				  OrthoNumber=610;
			  }
			  
			//  System.out.println("Orth nubmer = " +  OrthoNumber);
			  
		  }
		  
		  /** rest key is R*/
		  if (Keyboard.isKeyDown(Keyboard.KEY_R))
			  MyArcball.reset();
		  
		  /* bad animation can be turn on or off using A key)*/
		  
/*		if (Keyboard.isKeyDown(Keyboard.KEY_A))
			BadAnimation=!BadAnimation;
		if (Keyboard.isKeyDown(Keyboard.KEY_D))
			x += 0.35f * delta;

		if (Keyboard.isKeyDown(Keyboard.KEY_W))
			y += 0.35f * delta;
		if (Keyboard.isKeyDown(Keyboard.KEY_S))
			y -= 0.35f * delta;

		if (Keyboard.isKeyDown(Keyboard.KEY_Q))
			rotation += 0.35f * delta;
		/*if (Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			Earth=!Earth;
		} */
		
		 if(waitForKeyrelease) // check done to see if key is released 
		 {
		if (Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			
			DRAWGRID = !DRAWGRID;
			Keyboard.next();
			if(Keyboard.isKeyDown(Keyboard.KEY_G))
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
			}
		}
		 }
		 
		 /** to check if key is released */
		 if(Keyboard.isKeyDown(Keyboard.KEY_G)==false)
			{
				waitForKeyrelease=true;
			}else
			{
				waitForKeyrelease=false;
				
			}
		 
		 
		 
			

		// keep quad on the screen
		if (x < 0)
			x = 0;
		if (x > 1200)
			x = 1200;
		if (y < 0)
			y = 0;
		if (y > 800)
			y = 800;

		updateFPS(); // update FPS Counter
		
		LastMouseX= MouseX;
		LastMouseY= MouseY ;
	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 * 
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		changeOrth();
		MyArcball.startBall(0, 0, 1200,800); 
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		FloatBuffer lightPos = BufferUtils.createFloatBuffer(4);
		lightPos.put(10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos2 = BufferUtils.createFloatBuffer(4);
		lightPos2.put(0f).put(1000f).put(0).put(-1000f).flip();

		FloatBuffer lightPos3 = BufferUtils.createFloatBuffer(4);
		lightPos3.put(-10000f).put(1000f).put(1000).put(0).flip();

		FloatBuffer lightPos4 = BufferUtils.createFloatBuffer(4);
		lightPos4.put(1000f).put(1000f).put(1000f).put(0).flip();

		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		// GL11.glEnable(GL11.GL_LIGHT0); // switch light #0 on // I've setup specific materials so in real light it will look abit strange 

		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_POSITION, lightPos); // specify the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT1); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, Utils.ConvertForGL(spot));

		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, lightPos3); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT2); // switch light #0 on
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glLight(GL11.GL_LIGHT3, GL11.GL_POSITION, lightPos4); // specify
																	// the
																	// position
																	// of the
																	// light
		GL11.glEnable(GL11.GL_LIGHT3); // switch light #0 on
		 GL11.glLight(GL11.GL_LIGHT3, GL11.GL_DIFFUSE, Utils.ConvertForGL(grey));

		GL11.glEnable(GL11.GL_LIGHTING); // switch lighting on
		GL11.glEnable(GL11.GL_DEPTH_TEST); // make sure depth buffer is switched
											// on
	 	GL11.glEnable(GL11.GL_NORMALIZE); // normalize normal vectors for safety
	 	GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		
		   GL11.glEnable(GL11.GL_BLEND);
       GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
          try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //load in texture
          

	}

	 

	public void changeOrth() {

		 GL11.glMatrixMode(GL11.GL_PROJECTION);
		 GL11.glLoadIdentity();
		  GL11.glOrtho(1200 -  OrthoNumber , OrthoNumber, (800 - (OrthoNumber  * 0.66f)) , (OrthoNumber * 0.66f), 100000, -100000);
		 	GL11.glMatrixMode(GL11.GL_MODELVIEW); 
		 	
		 	FloatBuffer CurrentMatrix = BufferUtils.createFloatBuffer(16); 
		 	GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, CurrentMatrix);
		 
		 //	if(MouseOnepressed)
		 //	{
		  
		 	MyArcball.getMatrix(CurrentMatrix); 
		 //	}
		 	
		    GL11.glLoadMatrix(CurrentMatrix);
		 	
	}

	/*
	 * You can edit this method to add in your own objects /  remember to load in textures in the INIT method as they take time to load 
	 * 
	 */
	public void renderGL() { 
		changeOrth();
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); 
		GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		GL11.glColor3f(0.5f, 0.5f, 1.0f); 
		 
		 myDelta =   getTime() - StartTime; 
		  float delta =((float) myDelta)/10000;
		  //delta is too fast ,so i set a slow time-delta1
		  float delta1 =((float) myDelta)/100; 
		   System.out.println(delta1);//easy to see what activity happen in which time
		  // code to aid in animation 
		 float theta = (float) (delta * 2 * Math.PI);
		 float thetaDeg = delta * 360; 
		  float posn_x = (float) Math.cos(theta); // same as your circle code in your notes 
		  float posn_y  = (float) Math.sin(theta);
		  float posn_z =(float) Math.tan(theta);
		  float posn_a =(float)theta*theta;//y=x^2,so player will be faster than before
		  float posn_b =(float)delta1;
		  
		  /*
		   * This code draws a grid to help you view the human models movement 
		   *  You may change this code to move the grid around and change its starting angle as you please 
		   */
		if(DRAWGRID)
		{
		GL11.glPushMatrix();
		Grid MyGrid = new Grid();
		GL11.glTranslatef(600, 400, 0); 
		GL11.glScalef(200f, 200f,  200f); 
		 MyGrid.DrawGrid();
		GL11.glPopMatrix();
		}
		//use different time to set look
		if(delta1<190){		
			//GLU.gluLookAt(-100,-20, -50,0 ,0, 0, 0, 1, 0);
			GLU.gluLookAt(50,-30, 100,0 ,0, 0, 0, 1, 0);	
		//GLU.gluLookAt(small is right look,small number means high look,0,0 ,0, 0, 0, 1:head is +y, 0);
		}
		
		if(delta1>190){
		GLU.gluLookAt(-50,-20, 50,0 ,0, 0, 0, 1, 0);
		}
		//up player
		GL11.glPushMatrix();
		if(delta1<190){
			Human MyHuman = new Human();
			Bike Mybike = new Bike();
			
			
			
			if (Keyboard.isKeyDown(Keyboard.KEY_A)){
			GL11.glTranslatef(500, 400,0 ); 
			GL11.glScalef(20f, 20f,20f); //缩放
			
			GL11.glTranslatef((float) (posn_b*0.3), 0.0f,0);				  
			GL11.glTranslatef(-32, 5f,0);
			GL11.glRotated(-90, 0.0f, 1.0f,0.0f);
			MyHuman.DrawHuman(delta*20,texture,texture2); 
			 Mybike.DrawBike(delta*9, texture,texture2); 		
			}
			
				
			if (Keyboard.isKeyDown(Keyboard.KEY_D)){
				GL11.glTranslatef(500, 400,0 ); 
				GL11.glScalef(20f, 20f,20f); //缩放
				
				GL11.glTranslatef((float) (posn_b*0.3), 0.0f,0);				  
				GL11.glTranslatef(-27, 0f,0);
				GL11.glRotated(-90, 0.0f, 1.0f,0.0f);
				MyHuman.DrawHuman(delta*20,texture,texture2); 
				 Mybike.DrawBike(delta*9, texture,texture2); 	
			}
			else{
				GL11.glTranslatef(500, 400,0 ); 
				GL11.glScalef(20f, 20f,20f); //缩放
				
				GL11.glTranslatef((float) (posn_b*0.3), 0.0f,0);				  
				GL11.glTranslatef(-30, 2.5f,0);
				GL11.glRotated(-90, 0.0f, 1.0f,0.0f);
				MyHuman.DrawHuman(delta*20,texture,texture2); 
				 Mybike.DrawBike(delta*9, texture,texture2); 	
			}
		}
		if(delta1>190){
			GL11.glTranslatef(1100, 430,0 ); 
			GL11.glScalef(20f,20f,20f);
			player3 Myplayer3 = new player3();
			Bike Mybike = new Bike();
			GL11.glTranslatef(-posn_x*10f, 0.0f,-posn_y*10f);
			GL11.glRotated(-thetaDeg, 0.0f, 1.0f,0.0f);
			Myplayer3.DrawHuman(delta*20,texture,texture2); 
			 Mybike.DrawBike(delta*9, texture,texture2); 
		}
		
		GL11.glPopMatrix();
		
	    //2017.png is used to be meadow
		GL11.glPushMatrix();
		TexCube cu = new TexCube() ;
		GL11.glTranslatef(1000, 4350,100*2 ); 
		GL11.glScalef(4000f, 4000f,4000f);
		cu.DrawTexCube(texture3);
		GL11.glPopMatrix();
		//destination
		GL11.glPushMatrix();
		win w = new win() ;
		GL11.glTranslatef(1250, 500,0  ); 
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		w.Drawwin();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		barrier b = new barrier() ;
		GL11.glTranslatef(300, 330,-320  ); //(前后,左右,)
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(300,340,-420  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(450, 370,-320  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(600, 370,-420  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(750, 330,-420  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(900, 370,-420  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
		GL11.glPushMatrix();
		GL11.glTranslatef(900, 420,-420  );
		GL11.glRotated(90, 0, 1.0, 0);
		GL11.glScalef(100f, 100f,100f);
		b.Drawbarrier();
		GL11.glPopMatrix();	
	}
		  

	public static void main(String[] argv) {
		MainWindow hello = new MainWindow();
		hello.start();
	}
	 
	Texture texture;
	Texture texture2;
	Texture texture3;

	public void init() throws IOException {
	         
	  texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/b.jpg"));
	  System.out.println("Texture 1 loaded okay ");
	  texture2 = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("res/a.png"));
	  System.out.println("Texture 2 loaded okay ");
	  texture3 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/2017.png"));
	  System.out.println("Texture 3 loaded okay ");
	}
}