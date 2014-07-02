package com.stanfy.enroscar.async.content;

import android.content.ContentResolver;
import android.database.Cursor;

import com.stanfy.enroscar.async.Releaser;

import static com.stanfy.enroscar.async.content.BaseCursorAsyncBuilder.Params;

/**
 * {@link com.stanfy.enroscar.async.Async} implementation that queries a cursor from
 * content resolver.
 * @author Roman Mazur - Stanfy (http://stanfy.com)
 */
final class CursorAsync extends ContentObserverAsync<Cursor, ContentProviderQuery>
    implements Releaser<Cursor> {

  CursorAsync(final ContentProviderQuery query) {
    super(query);
  }

  @Override
  public CursorAsync replicate() {
    return new CursorAsync(getTask());
  }

  @Override
  protected ContentResolver getResolver() {
    return getTask().resolver;
  }

  @Override
  protected Params getParams() {
    return getTask().params;
  }


  @Override
  public void release(final Cursor data) {
    data.close();
  }

}
