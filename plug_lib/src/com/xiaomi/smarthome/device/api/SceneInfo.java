package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 场景信息类
 *
 * ApiLevel:8
 *
 */
public class SceneInfo implements Parcelable {

    /**
     * ApiLevel:8
     */
    public static final int LAUNCH_CLICK = 0;
    public static final int LAUNCH_TIMER = 1;
    public static final int LAUNCH_DEVICE = 2;
    public static final int LAUNCH_LEAVE_HOME = 3;
    public static final int LAUNCH_COME_HOME = 4;
    public static final int LAUNCH_MIKEY = 5;
    public static final int LAUNCH_MIBAND = 6;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSceneId);
        dest.writeInt(mRecommId);
        dest.writeString(mName);
        dest.writeInt(mEnable ? 1 : 0);
        dest.writeList(mLaunchList);
        dest.writeList(mActions);
    }

    public SceneInfo() {

    }

    public SceneInfo(Parcel in) {
        readFromParcel(in);
    }

    void readFromParcel(Parcel in) {
        mSceneId = in.readInt();
        mName = in.readString();
        mEnable = in.readInt() == 1;
        mLaunchList = new ArrayList<SceneLaunch>();
        in.readList(mLaunchList, SceneLaunch.class.getClassLoader());
        mActions = new ArrayList<SceneAction>();
        in.readList(mActions, SceneAction.class.getClassLoader());
    }

    /**
     * ApiLevel:8
     */
    public int mSceneId;
    /**
     * ApiLevel:8
     */
    public int mRecommId;
    /**
     * ApiLevel:8
     */
    public String mName;
    /**
     * ApiLevel:8
     */
    public boolean mEnable;
    /**
     * ApiLevel:16
     */
    public List<SceneLaunch> mLaunchList;
    /**
     * ApiLevel:8
     */
    public List<SceneAction> mActions;

    /**
     * ApiLevel:8
     */
    public static class SceneLaunch implements Parcelable {
        /**
         * ApiLevel:8
         */
        public int mLaunchType;
        /**
         * ApiLevel:8
         */
        public String mLaunchName;
        /**
         * ApiLevel:8
         */
        public String mDeviceModel;
        /**
         * ApiLevel:8
         */
        public String mEventString;
        /**
         * ApiLevel:8
         */
        public String mEventValue;
        /**
         * ApiLevel:16
         */
        public String mDid;
        /**
         * ApiLevel:16
         */
        public String mExtra;

        public SceneLaunch() {

        }

        public SceneLaunch(Parcel in) {
            mLaunchType = in.readInt();
            mLaunchName = in.readString();
            mDeviceModel = in.readString();
            mEventString = in.readString();
            mEventValue = in.readString();
            mDid = in.readString();
            mExtra = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(mLaunchType);
            dest.writeString(mLaunchName);
            dest.writeString(mDeviceModel);
            dest.writeString(mEventString);
            dest.writeString(mEventValue);
            dest.writeString(mDid);
            dest.writeString(mExtra);
        }

        public static final Parcelable.Creator<SceneLaunch> CREATOR = new Parcelable.Creator<SceneLaunch>() {

            @Override
            public SceneLaunch createFromParcel(Parcel source) {
                return new SceneLaunch(source);
            }

            @Override
            public SceneLaunch[] newArray(int size) {
                return new SceneLaunch[size];
            }
        };
    }

    /**
     * ApiLevel:8
     */
    public static class SceneAction implements Parcelable{
        /**
         * ApiLevel:8
         */
        public String mDeviceName;
        /**
         * ApiLevel:8
         */
        public String mDeviceModel;
        /**
         * ApiLevel:8
         */
        public String mActionName;
        /**
         * ApiLevel:8
         */
        public String mActionString;
        /**
         * ApiLevel:16
         */
        public String mActionValue;
        /**
         * ApiLevel:16
         */
        public String mDid;
        /**
         * ApiLevel:16
         */
        public String mExtra;

        public SceneAction() {

        }

        public SceneAction(Parcel in) {
            mDeviceName = in.readString();
            mDeviceModel = in.readString();
            mActionName = in.readString();
            mActionString = in.readString();
            mActionValue = in.readString();
            mDid = in.readString();
            mExtra = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mDeviceName);
            dest.writeString(mDeviceModel);
            dest.writeString(mActionName);
            dest.writeString(mActionString);
            dest.writeString(mActionValue);
            dest.writeString(mDid);
            dest.writeString(mExtra);
        }

        public static final Parcelable.Creator<SceneAction> CREATOR = new Parcelable.Creator<SceneAction>() {

            @Override
            public SceneAction createFromParcel(Parcel source) {
                return new SceneAction(source);
            }

            @Override
            public SceneAction[] newArray(int size) {
                return new SceneAction[size];
            }
        };
    }

    public static final Parcelable.Creator<SceneInfo> CREATOR = new Parcelable.Creator<SceneInfo>() {

        @Override
        public SceneInfo createFromParcel(Parcel source) {
            return new SceneInfo(source);
        }

        @Override
        public SceneInfo[] newArray(int size) {
            return new SceneInfo[size];
        }
    };
}