package com.nhlstenden.appstore.appstore;

import com.nhlstenden.appstore.DownloadNotAllowedException;
import com.nhlstenden.appstore.data.App;
import com.nhlstenden.appstore.data.Currency;
import com.nhlstenden.appstore.data.Purchase;
import com.nhlstenden.appstore.data.User;

import java.util.ArrayList;
import java.util.List;

public abstract class AppStore
{
    private Currency currency;
    private List<App> apps;
    private List<Purchase> purchases;

    protected AppStore(Currency currency)
    {
        this.setCurrency(currency);
        this.setApps(new ArrayList<>());
        this.setPurchases(new ArrayList<>());
    }

    public Currency getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(Currency currency)
    {
        if (currency == null)
        {
            throw new IllegalArgumentException("Currency cannot be null.");
        }

        this.currency = currency;
    }

    public List<App> getApps()
    {
        return this.apps;
    }

    public void setApps(List<App> apps)
    {
        if (apps == null)
        {
            throw new IllegalArgumentException("Apps cannot be null.");
        }

        this.apps = apps;
    }

    public List<Purchase> getPurchases()
    {
        return this.purchases;
    }

    public void setPurchases(List<Purchase> purchases)
    {
        if (purchases == null)
        {
            throw new IllegalArgumentException("Purchases cannot be null.");
        }

        this.purchases = purchases;
    }

    public abstract void uploadApp(App app);

    public abstract double getStoreShare();

    public void addApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null.");
        }

        if (!this.getApps().contains(app))
        {
            this.getApps().add(app);
        }
    }

    public void purchase(User user, App app) throws DownloadNotAllowedException
    {
        if (user == null || app == null)
        {
            throw new IllegalArgumentException("User and app cannot be null.");
        }

        if (!this.getApps().contains(app))
        {
            throw new IllegalArgumentException(app + " is not available in this store.");
        }

        if (!app.canBeUsedBy(user.getAge()))
        {
            throw new DownloadNotAllowedException(user + " is not allowed to download " + app + ".");
        }

        this.getPurchases().add(new Purchase(user, app));
    }

    public double getTotalRevenue()
    {
        double total = 0;

        for (Purchase purchase : this.getPurchases())
        {
            total += purchase.getApp().getPrice() * this.getStoreShare();
        }

        return total;
    }

    public double getRevenueForApp(App app)
    {
        double total = 0;

        for (Purchase purchase : this.getPurchases())
        {
            if (purchase.getApp() == app)
            {
                total += app.getPrice() * this.getStoreShare();
            }
        }

        return total;
    }
}