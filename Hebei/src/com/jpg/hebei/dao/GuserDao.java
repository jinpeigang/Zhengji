package com.jpg.hebei.dao;

import com.jpg.hebei.model.Guser;
import com.jpg.hebei.model.Suser;

public interface GuserDao {
  public boolean checkGuserByNamePass(Guser guser); 
  public Guser loadGuser(String username);
}
