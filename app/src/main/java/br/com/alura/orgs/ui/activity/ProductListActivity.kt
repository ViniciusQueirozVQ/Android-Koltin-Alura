package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductListActivity : AppCompatActivity(R.layout.activity_product_list) {
    private val dao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.findAll())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReciclerViewerConfig()
        FabConfig()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
    }

    private fun FabConfig() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_product_list_fab)
        goToProductForm(fab)
    }

    private fun goToProductForm(fab: FloatingActionButton) {
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ReciclerViewerConfig() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_product_list_recycler_view)
        recyclerView.adapter = adapter
    }

}