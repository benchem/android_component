package team.benchan.androiddemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import team.benchan.androiddemo.component.TaskPageDetailFragment;
import team.benchan.androiddemo.component.TaskPageLabelFragment;
import team.benchan.androiddemo.component.TaskPageListFragment;

public class MainActivity extends AppCompatActivity {

    MainActivityBinding binding;
    FragmentPagerAdapter pagerAdapter;
    List<Fragment> fragmentArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fragmentArray.add(new TaskPageListFragment());
        fragmentArray.add(new TaskPageDetailFragment());
        fragmentArray.add(new TaskPageLabelFragment());

        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragmentArray.size();
            }

            @Override
            public Fragment getItem(int i) {
                return fragmentArray.get(i);
            }
        };
        binding.viewPager.setAdapter(pagerAdapter);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                binding.viewPagerHeader.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        binding.viewPagerHeader.setSplitCount(fragmentArray.size());
    }
}
