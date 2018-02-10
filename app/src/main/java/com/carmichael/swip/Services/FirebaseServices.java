package com.carmichael.swip.Services;

import android.util.Log;

import com.carmichael.swip.Models.TradeItem;
import com.carmichael.swip.Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by carte on 2/10/2018.
 */

public class FirebaseServices {
    private static final String TAG = "FirebaseServices";

    public static TradeItem convertJsonToTradeItem(TradeItem tradeItem, String json, String itemKey){
        try{
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(json);
            tradeItem = gson.fromJson(json,TradeItem.class);
            tradeItem.setItemId(itemKey);
        }catch(Exception e){
            Log.e(TAG, "convertJsonToTradeItem: could not convert item", e);
        }
        return tradeItem;
    }

    public static ArrayList<TradeItem> convertTradeItemJsonToArray(ArrayList<TradeItem> tradeItems, String json){
        try{
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(json);
            Iterator x = jsonObject.keys();
            JSONArray jsonArray = new JSONArray();

            while (x.hasNext()){
                String key = (String) x.next();
                JSONObject toPut = new JSONObject(jsonObject.get(key).toString());
                toPut.put("itemId",key);
                jsonArray.put(toPut);
            }
            tradeItems = gson.fromJson(jsonArray.toString(), new TypeToken<List<TradeItem>>(){}.getType());
        }catch(Exception e){
            Log.e(TAG, "convertTradeItemJsonToArray: unable to convert TradeItem object into array", e);
        }
        return tradeItems;
    }

    public static ArrayList<User> convertUserJsonToArray(ArrayList<User> users, String json){
        try{
            Gson gson = new Gson();
            JSONObject jsonObject = new JSONObject(json);
            Iterator x = jsonObject.keys();
            JSONArray jsonArray = new JSONArray();

            while (x.hasNext()){
                String key = (String) x.next();
                JSONObject toPut = new JSONObject(jsonObject.get(key).toString());
                toPut.put("itemId",key);
                jsonArray.put(toPut);
            }
            users = gson.fromJson(jsonArray.toString(), new TypeToken<List<User>>(){}.getType());
        }catch(Exception e){
            Log.e(TAG, "convertTradeItemJsonToArray: unable to convert TradeItem object into array", e);
        }
        return users;
    }
}