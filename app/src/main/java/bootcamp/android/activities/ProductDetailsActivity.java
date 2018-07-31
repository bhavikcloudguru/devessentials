package bootcamp.android.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import bootcamp.android.R;
import bootcamp.android.fragment.MyFragment;
import bootcamp.android.models.Product;


public class ProductDetailsActivity extends FragmentActivity {

  /*  int index = 0;

    Bundle args = new Bundle();
*/
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details_container);
        /*Bundle extraArguments = getIntent().getExtras();
        this.index = extraArguments.getInt("index");
        args.putParcelable("product", extraArguments.getParcelableArrayList("products").get(this.index));
        createFragment(this.index);*/

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        Bundle arg = new Bundle();
        arg.putParcelableArrayList("products", getIntent().getExtras().getParcelableArrayList("products"));
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), arg);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(getIntent().getExtras().getInt("index"));
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        Bundle arg;

        public MyPagerAdapter(FragmentManager fm, Bundle arg) {
            super(fm);
            this.arg = arg;
        }

        @Override
        public Fragment getItem(int position) {

            Product p = (Product) arg.getParcelableArrayList("products").get(position);
            arg.putParcelable("product", p);
            return MyFragment.newInstance(arg);
        }

        @Override
        public int getCount() {
            return arg.getParcelableArrayList("products").size();
        }
    }
/*
    public void next(View view) {

        createFragment(++this.index);
    }

    public void previous(View view) {
        createFragment(--this.index);
    }

    public void createFragment(int i) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MyFragment fragment;
        fragment = new MyFragment();
        args.putParcelable("product",getIntent().getExtras().getParcelableArrayList("products").get(i));
        fragment.setArguments(args);
        fragmentTransaction.replace(R.id.product_details_container, fragment);
        fragmentTransaction.commit();
    }
*/

}
