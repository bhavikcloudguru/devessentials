package bootcamp.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bootcamp.android.R;
import bootcamp.android.models.Product;

public class MyFragment extends Fragment {

    public static MyFragment newInstance(Bundle args) {
        MyFragment instance = new MyFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.product_details, container, false);
        return getPopulatedView(inflater, container, getArguments());
    }


    private View getPopulatedView(LayoutInflater layoutInflater, ViewGroup parent, Bundle extraArguments) {
        View productDetailsView = layoutInflater.inflate(R.layout.product_details, parent, false);
        Product product = extraArguments.getParcelable("product");
        TextView imageTitle = (TextView) productDetailsView.findViewById(R.id.product_title);
        imageTitle.setText(product.getTitle());
        ImageView imageView = (ImageView) productDetailsView.findViewById(R.id.product_image);
        Picasso.with(getActivity()).load(product.getImageUrl()).into(imageView);
        TextView issueDescription = (TextView) productDetailsView.findViewById(R.id.product_description);
        issueDescription.setText(product.getDescription());
        return productDetailsView;
    }
}
