package sdm.project.guicomponents;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sdm.project.core.entities.Symbol;

public class SymbolImageView extends ImageView {

    public SymbolImageView(Symbol symbol){
        super((symbol == Symbol.CIRCLE) ?
                new Image(SymbolImageView.class.getResourceAsStream("/images/circle.png")) :
                new Image(SymbolImageView.class.getResourceAsStream("/images/cross.png")));
        setCache(true);
        setSmooth(true);
        setFitHeight(50);
        setFitWidth(50);
    }

}
