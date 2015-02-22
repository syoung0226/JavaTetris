package block;

public class BlockFactory {

    private BlockFactory() {

    }

    public static Block createBlock() {
        Block block =  null;
        double seed = Math.random();
        if(seed <= 0.14) {
            block = new JBlock();
        }else if(0.14 < seed && seed <=0.28 ){
            block = new LineBlock();
        }else if(0.28 < seed && seed <= 0.42 ){
        	block = new TBlock();
        }else if(0.42 < seed && seed <= 0.64 ){
        	block = new SquareBlock();
        }else if(0.64 < seed && seed <= 0.78 ){
        	block = new SBlock();
        }else if(0.78 < seed && seed <= 0.82 ){
           	block = new ZBlock();        	
        }else if(0.82 < seed && seed <= 1.0 ){
        	block = new LBlock();
        }
        return block;
    }
}