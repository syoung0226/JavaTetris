package block;

/**
 * Created by junhoi on 2015. 2. 15..
 */
public class BlockFactory {

    private BlockFactory() {

    }

    public static Block createBlock() {
        Block block =  null;
        double seed = Math.random();
        if(seed <= 1.0) {
            block = new LineBlock();
        }
        return block;
    }
}
