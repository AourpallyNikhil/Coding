package com.asu.edu.WordCount;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	private IntWritable result = new IntWritable();  
	public void reduce(Text key, Iterable<IntWritable> values, Context context)  throws IOException, InterruptedException{
		int output = 0;
		for(IntWritable each : values){
			output = output + each.get();
		}
		result.set(output);
		context.write(key,result);
	}
}
