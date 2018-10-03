package team.benchan.androiddemo.component;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import team.benchan.androiddemo.R;
import team.benchan.androiddemo.TaskPageListFragmentBinding;

public class TaskPageListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TaskPageListFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_taskpage_list, container, false);
        return binding.getRoot();
    }
}
