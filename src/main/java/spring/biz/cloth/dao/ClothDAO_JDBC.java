package spring.biz.cloth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spring.biz.cloth.vo.ClothVO;
import util.JDBCUtil;

public class ClothDAO_JDBC implements ClothDAO{

	public ClothDAO_JDBC() {
		
	}
	
	@Override
	public int addCloth(ClothVO cloth) {
		String sql = "insert into cloth (clothid, userid, imgpath, imgname, season, kind, color) values ((select mvl(max(clothid,0)+1 from cloth), ?, ?, ?, ?, ?, ?) "; 
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		ClothVO vo = null;	
		
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//세팅
			ps.setInt(1, cloth.getClothid());
			ps.setString(2, cloth.getUserid());
			ps.setString(3, cloth.getImgpath());
			ps.setString(4, cloth.getImgname());
			ps.setString(5, cloth.getSeason());
			ps.setString(6, cloth.getKind());
			ps.setString(7, cloth.getColor());
			//실행
			row = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}

	@Override
	public List<ClothVO> getClothList() {
		String sql = "select * from cloth ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		ClothVO vo = null;
		List<ClothVO> list = new ArrayList<ClothVO>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//세팅
			//실행
			rs = ps.executeQuery();
			//결과값
			while(rs.next()) {
				vo = new ClothVO();
				vo.setClothid(rs.getInt("clothid"));
				vo.setUserid(rs.getString("userid"));
				vo.setImgpath(rs.getString("imgpath"));
				vo.setImgname(rs.getString("imgname"));
				vo.setSeason(rs.getString("season"));
				vo.setKind(rs.getString("kind"));
				vo.setColor(rs.getString("color"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public List<ClothVO> getCloth(String uid, String kind) {
		String sql = "select * from cloth where userid = ? and kind = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		ClothVO vo = null;
		List<ClothVO> list = new ArrayList<ClothVO>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//세팅
			ps.setString(1, uid);
			ps.setString(2, kind);
			//실행
			while(rs.next()) {
				vo = new ClothVO();
				vo.setClothid(rs.getInt("clothid"));
				vo.setUserid(rs.getString("userid"));
				vo.setImgpath(rs.getString("imgpath"));
				vo.setImgname(rs.getString("imgname"));
				vo.setSeason(rs.getString("season"));
				vo.setKind(rs.getString("kind"));
				vo.setColor(rs.getString("color"));
				vo.setReg_date(rs.getDate("regdate"));
				list.add(vo);
			}
			rs = ps.executeQuery();
			//결과값
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public int updateCloth(ClothVO cloth) {
		String sql = "update cloth set imgpath=?,imgname=?,season=?,kind=?,color=? where clothid =?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		ClothVO vo = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//세팅
			ps.setString(1, cloth.getImgpath());
			ps.setString(2, cloth.getImgname());
			ps.setString(3, cloth.getSeason());
			ps.setString(4, cloth.getKind());
			ps.setString(5, cloth.getColor());
			ps.setInt(6, cloth.getClothid());
			//실행
			row = ps.executeUpdate();
			//결과값
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}

	@Override
	public int removeCloth(Integer cid) {
		String sql = "delete from cloth where clothid  = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0;
		ClothVO vo = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//세팅
			ps.setInt(1, cid);
			//실행
			row = ps.executeUpdate();
			//결과값
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return row;
	}
	
	
	
}
