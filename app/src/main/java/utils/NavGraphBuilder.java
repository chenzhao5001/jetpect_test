package utils;

import android.content.ComponentName;

import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;

import com.cz.jetpack.libcommon.AppGlobals;
import com.cz.jetpack.study.model.Destination;

import java.util.HashMap;

public class NavGraphBuilder {

    public static void build(NavController controller) {
        NavigatorProvider provider = controller.getNavigatorProvider();
        FragmentNavigator fragmentNavigator = provider.getNavigator(FragmentNavigator.class);
        ActivityNavigator activityNavigator = provider.getNavigator(ActivityNavigator.class);
        HashMap<String, Destination> destConfig = AppConfig.getDestConfig();

        NavGraph navGraph = new NavGraph(new NavGraphNavigator(provider));
        for(Destination value : destConfig.values()) {
            if(value.isFragment) {
                FragmentNavigator.Destination destination = fragmentNavigator.createDestination();
                destination.setClassName(value.clazzName);
                destination.setId(value.id);
                destination.addDeepLink(value.pageUrl);
                navGraph.addDestination(destination);
            } else {
                ActivityNavigator.Destination destination = activityNavigator.createDestination();
                destination.setComponentName(new ComponentName(AppGlobals.getApplication(),value.clazzName));
                destination.setId(value.id);
                destination.addDeepLink(value.pageUrl);
                navGraph.addDestination(destination);
            }

            if(value.asStarter) {
                navGraph.setStartDestination(value.id);
            }
        }
        controller.setGraph(navGraph);

    }
}
