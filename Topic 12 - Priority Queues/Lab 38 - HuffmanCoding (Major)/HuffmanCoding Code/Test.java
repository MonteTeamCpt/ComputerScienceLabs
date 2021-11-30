import java.io.*;

public class Test 
{
	public static void main(String[] args)
    {
        String txtFileName = "happy hip hop";
        
        HuffmanTree tree = new HuffmanTree(txtFileName + ".code");
        HuffmanCompressor compressor = new HuffmanCompressor();
        
        compressor.compress(txtFileName + ".txt");
        compressor.expand(	txtFileName + ".code",  "" + 
        			  		txtFileName + ".short", "" + 
        			  		txtFileName + ".new");
        	
    }

}
