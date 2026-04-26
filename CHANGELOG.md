# 更新记录

重要变更按时间汇总；与 `git log` 互证。制品（S5 单页）在入库前多轮迭代，摘要见「历史制品」一节。

---

## 2026-04-26

### 仓库与文档

- 初始化：入库存 **`S5-Residency-Countdown.html`**、**`archive/`** 旧版 HTML、**`README.md`**、**`.gitignore`**、**`docs/github-setup.md`**。  
- 简化 README，压缩推送速查。  
- 配置远程 **`origin`** → `https://github.com/Spark-Lab-Global/residency-countdown.git`；以 GitHub `noreply` 邮箱重写作业历史后完成首次推送。  
- GitHub 上小改 README 文案。  
- README 顶部标题区居中，并持续微调版式与导航。  
- README 增加 Shields 徽标行（**Spark Lab · Global**、**HTML5**、**build none**、**Awesome**、**private**）。

### 历史制品（S5 单页，摘要 · 无单独版本号）

以下在纳入本仓库前已在单文件中完成，供审计与回顾：

- 主周期：以上海墙钟为锚（如 **2026-04-26 12:00** 起、**+42 天**止等，以文件内 `CONFIG` 为准）。  
- 起止**前后各 10s** 边界闪烁、白/黑底与停表逻辑统一读 **`CONFIG.startDate` / `endDate`**。  
- 白底时左上角 Ship it、右上角生命体征、底部 `sparklab.city` 等对比度与字重；Ship it 周进度、仪式时刻等与「主倒计时」分工清晰。  
- 防御性：ISO/Intl 回退、`#residencyTagline` 终态不改编文案、仪式/画布的判空等。

---

*格式：新条目加在上表日期块顶部；大版本若需要可再引入 `[x.y.z]` 标签。*
