package ctesting.redditexample.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import ctesting.redditexample.internal.di.HasComponent;

/**
 * Created by Uri Abad on 23/08/16.
 * Seidor S.A.
 * oabad@seidor.es
 */
public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();

    }

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType){
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
