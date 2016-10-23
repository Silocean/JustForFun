package com.hblg.dao;

import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.GoodsMove;

public class GoodsMoveDAO extends DAO {

	/**
	 * ������Ʒ�Ǽ���Ϣ
	 */
	public boolean save(GoodsMove gm) {
		try {
			String sql = "insert into goodsMove values(?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, gm.getGodsStuId());
			pst.setString(2, gm.getGodsId());
			pst.setString(3, gm.getGodsInTime());
			pst.setString(4, gm.getGodsLevTime());
			pst.setString(5, gm.getGodsWatchId());
			pst.setString(6, gm.getGodsRemark());
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

	/**
	 * ��ȡ������Ʒ���
	 */
	public List<String> getAllGodsId() {
		try {
			List<String> list = new ArrayList<String>();
			String sql = "select godsId from goodsMove";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1).trim());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * �������ڻ�ȡ��Ʒ�Ǽ���ϸ��Ϣ
	 */
	public List<GoodsMove> getGodsMovInfoByDate(String date) {
		try {
			List<GoodsMove> list = new ArrayList<GoodsMove>();
			String sql = "select * from goodsMove where godsInTime like ? or godsLevTime like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + date + "%");
			pst.setString(2, "%" + date + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				GoodsMove gm = new GoodsMove();
				gm.setGodsStuId(rs.getString(1).trim());
				gm.setGodsId(rs.getString(2).trim());
				gm.setGodsInTime(rs.getString(3).trim());
				gm.setGodsLevTime(rs.getString(4).trim());
				gm.setGodsWatchId(rs.getString(5).trim());
				gm.setGodsRemark(rs.getString(6).trim());
				list.add(gm);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * ������Ʒ���ɾ����Ʒ�Ǽ���Ϣ(���������)
	 */
	public boolean deleteGodsInfoByGoodsId(List<String> goodsIdList) {
		try {
			String sql = "delete from goodsMove where godsId = ?";
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < goodsIdList.size(); i++) {
				pst.setString(1, goodsIdList.get(i));
				pst.addBatch();
			}
			boolean flag = true;
			int[] result = pst.executeBatch();
			for (int i = 0; i < result.length; i++) {
				if (result[i] != 1) {
					flag = false; // ɾ������
				}
			}
			if (flag) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

}
