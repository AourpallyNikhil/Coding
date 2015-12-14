package com.asu.edu.WordCount;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;

public class WordMapper extends Mapper<Object, Text, Text, IntWritable>{
	
	private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
	
	@Override
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
		String line = value.toString().toLowerCase();
		String [] words = line.split(" ");
		for(String each :  words){
			word.set(each);
			context.write(word,one);
		}
}
}
