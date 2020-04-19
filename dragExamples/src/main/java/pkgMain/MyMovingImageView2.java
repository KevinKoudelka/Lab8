package pkgMain;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/*
 * 
 */

public class MyMovingImageView2 extends Application {

	private ImgController2 imc;
	private ImageView iv1;
	private final double WIDTH = 800;
	private final double HEIGHT = 600;
	TilePane tile = new TilePane();
	FlowPane flow = new FlowPane();
	ArrayList<ImageView> imgArr;
	Image im1;
	double plantSize = 100;
	
	public MyMovingImageView2(){
    	iv1 = new ImageView();
		imc = new ImgController2(this);
		imgArr = new ArrayList<ImageView>();
	}
		
    @Override
    public void start(Stage stage) {
    	
    	Image im1 = new Image(getClass().getResourceAsStream("/img/commonMilkweed.png"));
    	iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	iv1.setOnMouseDragged(imc.getHandlerForDrag());
    	iv1.setOnMouseReleased(imc.getHandlerForRelease());
    	
    	tile.getChildren().add(iv1);
    	tile.setMaxHeight(100);
    	tile.setMaxWidth(200);
        tile.setTileAlignment(Pos.TOP_LEFT);
        
        flow.setMaxHeight(100);
        flow.setMaxWidth(200);
        tile.setTileAlignment(Pos.BOTTOM_LEFT);
        
        StackPane stack = new StackPane();
        stack.getChildren().add(tile);
        stack.getChildren().add(flow);
        
    	Scene scene = new Scene(stack, WIDTH, HEIGHT);
        stage.setScene(scene);
        
		iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + imc.getStartingX());
		iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + imc.getStartingY());

        stage.show();
    }
    public void setX(double x) {
    	iv1.setTranslateX(iv1.getLayoutX() - WIDTH/2 + x);
    }
    public void setY(double y) {
    	iv1.setTranslateY(iv1.getLayoutY() - HEIGHT/2 + y);
    }
    
    public int createImg() {
    	
    	imgArr.add(new ImageView());
    	int arrNum = imgArr.size()-1;
    	ImageView view = imgArr.get(arrNum);
    	
    	view.setImage(new Image(getClass().getResourceAsStream("/img/commonMilkweed.png")));
    	view.setPreserveRatio(true);
    	view.setFitHeight(plantSize);
    	view.setOnMouseDragged(imc.getHandlerForDrag());
    	view.setOnMouseReleased(imc.getHandlerForRelease());
    	
    	flow.getChildren().add(imgArr.get(arrNum));
    	return arrNum;
    	
    }
    
    public static void main(String[] args) {
        launch();
    }

}