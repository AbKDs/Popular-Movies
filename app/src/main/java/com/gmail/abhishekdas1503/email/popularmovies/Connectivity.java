package com.gmail.abhishekdas1503.email.popularmovies;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * Connectivity class which helps in determining if the network
 * connection is fast or not and based upon that uses the resolution
 * of image to download
 */

public class Connectivity {

    /**
     * Get network info
     *
     * @param context Interface to global information about an application environment
     * @return        Information about the current network status
     */
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * Check for connectivity
     * @param context Interface to global information about an application environment
     * @return        True if connected to Internet
     */

    public static boolean isConnected(Context context) {
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        return ((networkInfo != null) && networkInfo.isConnected());
    }

    /**
     * Check for wifi connectivity
     * @param context Interface to global information about an application environment
     * @return        True if connected to wifi
     */
    public static boolean isConnectedWifi(Context context) {
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        return (networkInfo != null && networkInfo.isConnected() &&
                networkInfo.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * Check for mobile network connectivity
     * @param context Interface to global information about an application environment
     * @return        True if connected to mobile network
     */
    public static boolean isConnectedMobile(Context context) {
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        return (networkInfo != null && networkInfo.isConnected() &&
                networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    /**
     * Check for fast connectivity
     * @param context Interface to global information about an application environment
     * @return        True if connection is fast
     */
    public static boolean isConnectedFast(Context context){
        NetworkInfo networkInfo = Connectivity.getNetworkInfo(context);
        return (networkInfo != null && networkInfo.isConnected() &&
                Connectivity.isConnectionFast(networkInfo.getType(),networkInfo.getSubtype()));
    }

    /**
     * Utility function for checking fast connectivity
     * @param type      Type of network to which the info in this NetworkInfo pertains
     * @param subtype   Network-type-specific integer describing the subtype of the network
     * @return          True of connection is fast
     */

    private static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN:
                    return false;                          // 2G Network
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                case TelephonyManager.NETWORK_TYPE_EHRPD:
                case TelephonyManager.NETWORK_TYPE_HSPAP:
                    return true;                           // 3G Network
                case TelephonyManager.NETWORK_TYPE_LTE:
                    return true;
                default:                                   // 4G Network
                    return false;
            }
        } else {
            return false;
        }
    }
}
