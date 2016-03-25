package com.ssiot.remote.yun.monitor;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;

public final class TintedBitmapDrawable extends BitmapDrawable
{
  private int alpha;
  private int tint;//染色 着色

  public TintedBitmapDrawable(Resources paramResources, @DrawableRes int paramInt1, @ColorRes int paramInt2)
  {
    super(paramResources, BitmapFactory.decodeResource(paramResources, paramInt1));
    this.tint = paramResources.getColor(paramInt2);
    this.alpha = Color.alpha(this.tint);
  }

  public TintedBitmapDrawable(Resources paramResources, Bitmap paramBitmap, @ColorInt int paramInt)
  {
    super(paramResources, paramBitmap);
    this.tint = paramInt;
    this.alpha = Color.alpha(this.tint);
  }

  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = getPaint();
    if (localPaint.getColorFilter() == null)
    {
      localPaint.setColorFilter(new PorterDuffColorFilter(this.tint, android.graphics.PorterDuff.Mode.SRC_IN));
      localPaint.setAlpha(this.alpha);
    }
    super.draw(paramCanvas);
  }

  public void setSupportTint(@ColorInt int paramInt)
  {
    this.tint = paramInt;
    DrawableCompat.setTint(this, paramInt);
    this.alpha = Color.alpha(paramInt);
  }

  public void setTint(Resources paramResources, @ColorRes int paramInt)
  {
    int i = paramResources.getColor(paramInt);
    this.tint = i;
    DrawableCompat.setTint(this, i);
    this.alpha = Color.alpha(this.tint);
  }
}