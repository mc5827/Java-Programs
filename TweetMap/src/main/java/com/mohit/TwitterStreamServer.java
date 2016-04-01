package com.mohit;

public class TwitterStreamServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final TwitterStreamConsumer streamConsumer = new TwitterStreamConsumer(); // final because we will later pull the latest Tweet
	        streamConsumer.start();
	}

}
