package eniso.ia2.booksapp;

/**
 * Created by asus on 28/03/2018.
 */



        import java.util.List;

        import android.app.Activity;
        import android.content.Context;
        import android.graphics.Movie;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import com.android.volley.toolbox.ImageLoader;
        import com.android.volley.toolbox.ImageLoader;
        import com.android.volley.toolbox.NetworkImageView;

        import org.w3c.dom.Text;

public class CustomListAdapter extends BaseAdapter {
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    private Activity activity;
    private LayoutInflater inflater;
    private List<Book> bookItems;


    public CustomListAdapter(Activity activity, List<Book> bookItems) {
        this.activity = activity;
        this.bookItems = bookItems;
    }

    @Override
    public int getCount() {
        return bookItems.size();
    }

    @Override
    public Object getItem(int location) {
        return bookItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView author = (TextView) convertView.findViewById(R.id.author);
        TextView details=(TextView)convertView.findViewById(R.id.details) ;
        TextView userRating=(TextView)convertView.findViewById(R.id.userRating) ;
        NetworkImageView image = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        // getting Book data for the row
        Book m = bookItems.get(position);




        // title
        title.setText(m.getTitle());

        // author
        author.setText("Author: " + m.getAuthor());

        // rating
        rating.setText("Rating: " + String.valueOf(m.getRating()));

        // genre
       genre.setText("Genre:" +String.valueOf(m.getGenre()));

     //   details.setText("Summary:"+""+ m.getDetails());

        image.setImageUrl(m.getImageUrl(),imageLoader);

        return convertView;
    }


}
