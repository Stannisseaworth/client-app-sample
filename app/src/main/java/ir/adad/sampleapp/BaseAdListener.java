package ir.adad.sampleapp;

import org.json.JSONObject;

import ir.adad.client.AdListener;

/**
 * Created by navidfarshchi on 9/21/15.
 */
public abstract class BaseAdListener implements AdListener {

    @Override
    public void onAdLoaded() {

    }

    @Override
    public void onAdFailedToLoad() {

    }

    @Override
    public void onAdOpened() {

    }

    @Override
    public void onInterstitialClosed() {

    }

    @Override
    public void onMessageReceive(JSONObject jsonObject) {

    }

    @Override
    public void onRemoveAdsRequested() {

    }
}
