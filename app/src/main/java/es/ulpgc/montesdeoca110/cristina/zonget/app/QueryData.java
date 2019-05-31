package es.ulpgc.montesdeoca110.cristina.zonget.app;

import android.os.Parcel;
import android.os.Parcelable;

public class QueryData implements Parcelable {

    public String content;
    public String answer;

    public QueryData(String content, String answer) {
        this.content = content;
        this.answer = answer;
    }

    protected QueryData(Parcel in) {
        content = in.readString();
        answer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeString(answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QueryData> CREATOR = new Creator<QueryData>() {
        @Override
        public QueryData createFromParcel(Parcel in) {
            return new QueryData(in);
        }

        @Override
        public QueryData[] newArray(int size) {
            return new QueryData[size];
        }
    };
}
