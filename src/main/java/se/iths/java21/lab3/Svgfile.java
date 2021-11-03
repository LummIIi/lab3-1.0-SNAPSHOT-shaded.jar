package se.iths.java21.lab3;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.iths.java21.lab3.shapes.Shape;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Svgfile {

    private static final FileChooser fileChooser = new FileChooser();

    public static void saveFile(Model model) {
        fileChooser.setTitle("Save SVG File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG Format", "*.svg"));


        Path path = Path.of(fileChooser.showSaveDialog(new Stage()).getPath());
        List<String> list = new ArrayList<>();


        buildSVG(model, list);


            try {
                Files.write(path,list);
            } catch (IOException e) {
                e.printStackTrace();
            }







    }

    private static void buildSVG(Model model, List<String> list) {
        list.add(startOfSvg());
        model.getShapes().forEach(shape -> shapeSvgInfoToString(shape ,list));
        list.add(endOfSvgString());
    }


    private static String startOfSvg(){
        return "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"800.0\" height=\"500.0\">";
    }


    private static void shapeSvgInfoToString(Shape shape, List<String> list){
        list.add(shape.drawSVG());
    }


    private static String endOfSvgString(){
        return "</svg>";
    }


}
