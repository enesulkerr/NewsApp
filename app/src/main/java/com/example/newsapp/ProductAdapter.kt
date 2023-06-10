import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.models.Product

class ProductAdapter(context: Context, products: List<Product>) :
    ArrayAdapter<Product>(context, 0, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        // ViewHolder kullanarak performansı artırıyoruz
        val viewHolder: ViewHolder

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)

            // ViewHolder'ı oluştur ve içerisindeki görünümleri tanımla
            viewHolder = ViewHolder()
            viewHolder.imageView = convertView.findViewById(R.id.imageView)
            viewHolder.titleTextView = convertView.findViewById(R.id.titleTextView)
            viewHolder.subtitleTextView = convertView.findViewById(R.id.subtitleTextView)

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        // Ürünü al
        val product = getItem(position)
        // ViewHolder içerisindeki görünümlere verileri ata
        Glide.with(context)
            .load(product?.image)
            .override(200, 100) // Genişlik: 200dp, Yükseklik: 100dp
            .into(viewHolder.imageView!!)

        viewHolder.titleTextView?.text = product?.href
        viewHolder.subtitleTextView?.text = product?.title

        return convertView!!
    }

    // ViewHolder sınıfı
    private class ViewHolder {
        var imageView: ImageView? = null
        var titleTextView: TextView? = null
        var subtitleTextView: TextView? = null
    }
}
