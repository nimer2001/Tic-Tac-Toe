/**
 * this class represents a renderer factory
 */
public class RendererFactory {
    /**
     * a constructor
     */
    public RendererFactory(){

    }

    /**
     * this function build a renderer based on the type
     * @param type a string
     * @param size an int represents the size of the board.
     * @return a renderer
     */
    public Renderer buildRenderer(String type, int size){
        if(type.equalsIgnoreCase("Console")){
            return new ConsoleRenderer(size);
        }
        if(type.equalsIgnoreCase("none")){
            return new VoidRenderer();
        }
        return null;
    }
}
