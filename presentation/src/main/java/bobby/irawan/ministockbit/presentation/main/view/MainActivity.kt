package bobby.irawan.ministockbit.presentation.main.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import bobby.irawan.ministockbit.presentation.R
import bobby.irawan.ministockbit.presentation.databinding.ActivityMainBinding
import bobby.irawan.ministockbit.presentation.main.viewmodel.MainActivityViewModel
import bobby.irawan.ministockbit.presentation.utils.setGone
import bobby.irawan.ministockbit.presentation.utils.setVisible
import bobby.irawan.ministockbit.presentation.utils.showSuccessSnackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private val viewModel by viewModel<MainActivityViewModel>()
    private var isHideMenu = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.successSnackbar().observe(this) { message ->
            binding.root.showSuccessSnackbar(message)
        }
    }

    private fun setupView() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            binding.bottomNavigationMenu,
            navHostFragment.navController
        )

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.watchListFragment,
                R.id.dataFeedFragment,
                R.id.loginFragment
            )
        )

        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }

    fun showBottomNavigation() {
        binding.bottomNavigationMenu.setVisible()
    }

    fun hideBottomNavigation() {
        binding.bottomNavigationMenu.setGone()
    }

    fun hideMenu(state: Boolean) {
        isHideMenu = state
        invalidateOptionsMenu()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        if (isHideMenu) {
            menu?.findItem(R.id.sign_out)?.setVisible(false)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sign_out -> {
                viewModel.onUserSignOut()
                navHostFragment.findNavController().navigate(R.id.loginFragment, null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val navigationController = navHostFragment.findNavController()
        val currentDestId = navigationController.currentDestination?.id
        if (currentDestId == R.id.watchListFragment || currentDestId == R.id.loginFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}