package assignment.redmart.com.view;

import com.wang.avi.AVLoadingIndicatorView;

public class Loading implements LoadingInterface {
    private AVLoadingIndicatorView avi;

    public Loading(AVLoadingIndicatorView avi){
        this.avi = avi;
    }

    @Override
    public void start() {
        avi.show();
    }

    @Override
    public void stop() {
        avi.hide();
    }
}
