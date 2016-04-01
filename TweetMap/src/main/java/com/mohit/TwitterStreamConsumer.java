package com.mohit;

import java.util.HashSet;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamConsumer extends Thread {

	// private static final String STREAM_URI =
	// "https://stream.twitter.com/1.1/statuses/filter.json";
	private static final String YOUR_API_KEY = "5CgyISOSmrSVSow2V85zZqwUJ";
	private static final String YOUR_API_SECRET = "bHLtJqcmbumeGhbeenfdzR5GANisT7lrr2kRja2cbR6G01kVij";
	private static final String YOUR_OAuth_ACCESS_TOKEN = "92912097-zGtIYwVRF5BLDP8R4lAfl30doxwfNPjRbktKr0KP3";
	private static final String YOUR_OAuth_ACCESS_TOKEN_SECRET = "fvajCxzkAnjSRuwZHJm6oTnaVbZHHyduGbRYbgR9iNlnN";

	public void run() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(YOUR_API_KEY);
		cb.setOAuthConsumerSecret(YOUR_API_SECRET);
		cb.setOAuthAccessToken(YOUR_OAuth_ACCESS_TOKEN);
		cb.setOAuthAccessTokenSecret(YOUR_OAuth_ACCESS_TOKEN_SECRET);

		TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		final HashSet<Long> tweetIdLong = new HashSet<Long>();
		StatusListener listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStatus(Status status) {
				
            		User user = status.getUser();
                
                // gets Username
                	String username = status.getUser().getScreenName();
                
                	//System.out.println(username);
//                	String profileLocation = user.getLocation();
//                	System.out.println(profileLocation);
                	long tweetId = status.getId(); 
                	tweetIdLong.add(tweetId);
                	String location = status.getGeoLocation().getLatitude()+","+status.getGeoLocation().getLongitude();
                	System.out.println(tweetId+"-"+location);
                	String content = status.getText();
                	if(tweetIdLong.size()>5000){
                		System.err.println("bas kar yaar");
                		System.exit(0);
                	}
                	//System.out.println(content +"\n");
            	

			}

			@Override
			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}

		};
		FilterQuery fq = new FilterQuery();

		String keywords[] = { "london" };

		fq.track(keywords);

		twitterStream.addListener(listener);
		twitterStream.filter(fq);

	}
}