package com.mohit;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class SimpleStream {
	
	private static final String YOUR_API_KEY = "5CgyISOSmrSVSow2V85zZqwUJ";
    private static final String YOUR_API_SECRET = "bHLtJqcmbumeGhbeenfdzR5GANisT7lrr2kRja2cbR6G01kVij";
    private static final String YOUR_OAuth_ACCESS_TOKEN = "92912097-zGtIYwVRF5BLDP8R4lAfl30doxwfNPjRbktKr0KP3";
    private static final String YOUR_OAuth_ACCESS_TOKEN_SECRET = "fvajCxzkAnjSRuwZHJm6oTnaVbZHHyduGbRYbgR9iNlnN"; 
    
    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(YOUR_API_KEY);
        cb.setOAuthConsumerSecret(YOUR_API_SECRET);
        cb.setOAuthAccessToken(YOUR_OAuth_ACCESS_TOKEN);
        cb.setOAuthAccessTokenSecret(YOUR_OAuth_ACCESS_TOKEN_SECRET);

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        final int counter[]={1};
        final int total[]={1};
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
            	total[0]=total[0]+1;
            	System.out.println("total tweets: "+total[0]);
            	if(status.getGeoLocation()!=null){
            		System.out.println("GeoLocation counter: "+counter[0]);
                User user = status.getUser();
                counter[0]=counter[0]+1;
                // gets Username
                String username = status.getUser().getScreenName();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
                long tweetId = status.getId(); 
                System.out.println(tweetId);
                System.out.println("*******"+status.getGeoLocation());
                String content = status.getText();
                System.out.println(content +"\n");
            	}
            	else{
            		System.out.println("GeoLocation counter: "+counter[0]);
            		System.out.println("______________________________________");
            		System.out.println("Found but without geolocation set");
            		System.out.println("______________________________________");
            	}

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
    
        String keywords[] = {"thewalkingdead"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  

    }
}