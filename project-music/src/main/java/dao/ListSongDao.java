dao;

import .entity.ListSong;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ListSong)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-29 20:20:47
 */
public interface ListSongDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ListSong queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param listSong 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ListSong> queryAllByLimit(ListSong listSong, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param listSong 查询条件
     * @return 总行数
     */
    long count(ListSong listSong);

    /**
     * 新增数据
     *
     * @param listSong 实例对象
     * @return 影响行数
     */
    int insert(ListSong listSong);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ListSong> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ListSong> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ListSong> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ListSong> entities);

    /**
     * 修改数据
     *
     * @param listSong 实例对象
     * @return 影响行数
     */
    int update(ListSong listSong);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}

