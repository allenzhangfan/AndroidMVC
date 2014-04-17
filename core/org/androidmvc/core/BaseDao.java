package org.androidmvc.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.Log;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.db.sqlite.CursorUtils;
import net.tsz.afinal.db.sqlite.DbModel;
import net.tsz.afinal.db.sqlite.SqlBuilder;
import net.tsz.afinal.db.sqlite.SqlInfo;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.OneToMany;
import net.tsz.afinal.db.table.TableInfo;

public abstract class BaseDao {
	public Context context;
	private FinalDb db;
	protected static final String DB_NAME = "railsdroid";
	protected static final boolean IS_DEBUG = true;
	protected static final int DB_VERSION = 3;

	// /**
	// * 单例的实现
	// */
	// public static BaseService singleton = null;

	protected BaseDao(Context context) {
		this.context = context;
		this.db = FinalDb.create(context, DB_NAME, IS_DEBUG, DB_VERSION, null);
	}

	

	/**
	 * 保存数据库
	 * 
	 * @param entity
	 */
	protected void save(Object entity) {
		db.save(entity);
	}

	/**
	 * 更新数据，如果id为空则新增,并返回int型主键的值
	 * <p>
	 * 
	 * @author zhangfan
	 * @version 2014-1-27
	 * @param entity
	 * @return
	 */
	protected int saveOrUpdateReturnIntPK(Object entity) {
		return db.saveOrUpdateReturnIntPK(entity);
	}

	/**
	 * 更新数据，如果id为空则新增
	 * <p>
	 * 
	 * @author zhangfan 2013-12-18
	 * @param entity
	 * @return 该实体的主键值
	 */
	protected void saveOrUpdate(Object entity) {
		db.saveOrUpdate(entity);
	}

	/**
	 * 更新数据 （主键ID必须不能为空）
	 * 
	 * @param entity
	 */
	protected void update(Object entity) {
		db.update(entity);
	}

	/**
	 * 根据条件更新数据
	 * 
	 * @param entity
	 * @param strWhere
	 *            条件为空的时候，将会更新所有的数据
	 */
	protected void update(Object entity, String strWhere) {
		db.update(entity, strWhere);
	}

	/**
	 * 删除数据
	 * 
	 * @param entity
	 *            entity的主键不能为空
	 */
	protected void delete(Object entity) {
		db.delete(entity);
	}

	/**
	 * 根据主键删除数据
	 * 
	 * @param clazz
	 *            要删除的实体类
	 * @param id
	 *            主键值
	 */
	protected void deleteById(Class<?> clazz, Object id) {
		db.deleteById(clazz, id);
	}

	/**
	 * 根据条件删除数据
	 * 
	 * @param clazz
	 * @param strWhere
	 *            条件为空的时候 将会删除所有的数据
	 */
	protected void deleteByWhere(Class<?> clazz, String strWhere) {
		db.deleteByWhere(clazz, strWhere);
	}

	/**
	 * 根据主键查找数据（默认不查询多对一或者一对多的关联数据）
	 * 
	 * @param id
	 * @param clazz
	 */
	protected <T> T findById(Object id, Class<T> clazz) {
		return db.findById(id, clazz);
	}

	/**
	 * 查找所有的数据
	 * 
	 * @param clazz
	 */
	protected <T> List<T> findAll(Class<T> clazz) {
		return db.findAll(clazz);
	}

	/**
	 * 查找所有数据
	 * 
	 * @param clazz
	 * @param orderBy
	 *            排序的字段
	 */
	protected <T> List<T> findAll(Class<T> clazz, String orderBy) {
		return db.findAll(clazz, orderBy);
	}

	/**
	 * 根据条件查找所有数据
	 * 
	 * @param clazz
	 * @param strWhere
	 *            条件为空的时候查找所有数据
	 */
	protected <T> List<T> findAllByWhere(Class<T> clazz, String strWhere) {
		return db.findAllByWhere(clazz, strWhere);
	}

	/**
	 * 根据条件查找所有数据
	 * 
	 * @param clazz
	 * @param strWhere
	 *            条件为空的时候查找所有数据
	 * @param orderBy
	 *            排序字段
	 */
	protected <T> List<T> findAllByWhere(Class<T> clazz, String strWhere,
			String orderBy) {
		return db.findAllByWhere(clazz, strWhere, orderBy);
	}

	/**
	 * 根据sql语句查找数据，这个一般用于数据统计
	 * 
	 * @param strSQL
	 */
	protected DbModel findDbModelBySQL(String strSQL) {
		return db.findDbModelBySQL(strSQL);
	}

	protected List<DbModel> findDbModelListBySQL(String strSQL) {
		return db.findDbModelListBySQL(strSQL);
	}

	public void dropTable(Class<?> clazz) {
		db.dropTable(clazz);
	}

	public void execSql(String sql) {
		db.execSql(sql);
	}

	public void execSql(String sql, Object[] bindArgs) {
		db.execSql(sql, bindArgs);
	}

	/**
	 * 得到创建表的SQL
	 * <p>
	 * 
	 * @author zhangfan 2014-1-16
	 * @param clazz
	 * @return
	 */
	public String getCreateTableSql(Class<?> clazz) {
		return db.getCreateTableSql(clazz);
	}

	public String saveOrUpdateReturnUUIDPK(Object entity) {
		return db.saveOrUpdateReturnUUIDPK(entity);
	}

	/**
	 * 查找最新updateTime
	 */
	public Object findTheLatest(Class<?> clazz) {
		String className = clazz.getName().toString();
		DbModel model = null;
		if (findAll(clazz).size() > 0) {
			model = findDbModelBySQL("select max(updateTime) from "
					+ className.substring(className.lastIndexOf(".") + 1) + "");
		}
		if (model != null) {
			String updatetime = (String) model.get("max(updateTime)");
			Log.d("" + className.substring(className.lastIndexOf(".") + 1)
					+ " 最近更新的日期", updatetime);
			return findAllByWhere(clazz, "updateTime = '" + updatetime + "'")
					.get(0);
		} else {
			return null;
		}
	}

}
