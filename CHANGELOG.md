# 更新记录

本文档合并两路信息，便于审计与回顾：

1. **Git 提交**：以当前 `main` 分支线性历史为准（曾用 `filter-branch` / `rebase` 与 `noreply` 邮箱重写历史，旧 hash 可能仅存在于 `reflog`）。  
2. **单页 HTML 制品**：`S5-Residency-Countdown.html`（及过程中的 `S3-residency-countdown.html`）在**入仓库前与迭代对话中**完成的逻辑与 UI，按主题归纳；**具体时刻以文件内 `CONFIG` 与注释为准**。

---

## 一、`main` 分支提交索引（`git log` · 自旧到新）

> 下表为**当前**仓库中可检出的记录；同文案的多次提交在重写历史时可能已合并，此处不重复列旧 hash。

| 提交 | 说明 |
|------|------|
| `3c1f425` | 初始化：根目录 **S5** 主文件、`archive/` 下旧版 S3、**`README`**、**`.gitignore`**、**`docs/github-setup.md`**。 |
| `d430311` | 精简 README，推送说明收入 **`docs/github-setup.md`**。 |
| `7f1e1bf` | 将 **`origin`** 指向 **`https://github.com/Spark-Lab-Global/residency-countdown.git`** 并更新文档。 |
| `f0a257d` | 在 GitHub 上更新 README 文案。 |
| `dafb160` | README 标题区居中。 |
| `448306c` | 美化 README、**首次新增本 `CHANGELOG.md`**。 |
| `ecff940` | 更新 README 中的项目名称/展示名。 |
| `8d08454` | README 增加 **Shields** 徽标行（组织、HTML5、无构建、Awesome 风格、private 等）。 |
| `4e09a5f` | `CHANGELOG.md` 扩写：合并 `main` 提交索引与 S5/S3 单页制品主题追溯、维护说明。 |
| `ffd06b5` | README 主标题由「Residency 倒计时」改为「**倒计时**」。 |
| `2d2ff56` | README 下载步骤中补充 **Raw 或 直接点击下载**（为后续长版内网/本地下载两路径说明的衔接）。 |
| `d1e5fd5` | README：**内网** NAS（`http://10.10.10.4:5000/`）、先接 WiFi 再访问；**本地下载** 主路径 `Download raw file`、**Raw 备用**、Primer **下载**图标示意；**部署与参考** 链至 1Panel 博客；与下文本节同步。 |
| `2883ed5` | 仅文档：上一行短 hash 在 `commit --amend` 后已在表中更正为 `d1e5fd5`。 |
| `2155911` | README：内网写明 **Spark Lab / Spark Lab-5G** WiFi；主文件链改为「在**仓库**上的页面」等。 |
| `eb2e181` | README：**本地下载** 再精简，**Download raw file** 与图标配对说明收入**块引用**；**Raw 备用** 一句。 |
| `vercel` | 根目录 **`vercel.json`** 仅 **`/`** → **`S5-Residency-Countdown.html`**；README「部署与参考」与上文「仓库与元文件」一节、1Panel/NAS 并列、**不** 另建 `index.html`、**不** 用 `/(.*)` 全站劫持（提交见 `main` 上 *feat: …Vercel*）。 |
| `061cebc` | README：**网络使用**（原「内网使用」）：表列 **内网 NAS 优先**、**公网·Vercel（`residency-countdown.vercel.app`）备选**，并注明免费档配额与公网体验；顶栏「内网」改为「**网络**」。 |
| `contribs` | README：**联系与审核**（Jah-yee / WorldSansha·三傻）、**维护者** 与 [contrib.rocks 本库图](https://github.com/Spark-Lab-Global/residency-countdown/graphs/contributors)；提交见 `main` 上 *…联系/维护者…* 且含 **Co-authored-by** 三傻（NAS）。 |

**与远端推送相关**（未单独成 commit 的操作）：为符合 GitHub **不暴露私有邮箱** 策略，曾用 **`166608075+Jah-yee@users.noreply.github.com`** 重写作业者邮箱后执行 **`git push`**；本地为仓库配置 **`user.email`** 为上述 noreply。

---

## 二、单页制品追溯（S5 为主，兼及 S3）

以下变更主要落在 **`S5-Residency-Countdown.html`**；**`S3-residency-countdown.html`** 在部分迭代中曾同步过同类样式与 Ship it 逻辑，现归档在 **`archive/`**。

### 1. 主题、背景与主倒计时窗

- **非进行中 / 已结束**时使用 **白底**（`body.countdown-inactive`），进行中为 **黑底**；`body` 上 **背景色过渡**（如 1s ease）。  
- 主起止为 **上海墙钟** 的 **绝对时刻**（`new Date('…+08:00')` 与 **+42 天** 毫秒间隔）；**极古环境**若 ISO 解析失败则 **回退** 为本地 `Date(年,月,日,12,0,0,0)` 与 +42 天，并 **`console.warn`**。  
- 起、止时刻 **前后各 10s** 内为 **边界模式**（`countdown-flicker`）：**约每秒** 在「白底 inactive / 黑底 active」间切换，避免与 1s 长过渡糊在一起（短时 `transition`）。  
- 边界与日常态均 **只读** **`CONFIG.startDate` / `endDate`**，无第二套时间常量。  
- 主倒计时 **归零** 后展示完成行、进度拉满；**`clearInterval`** 延至 **`endTime + 10s`** 之后，保证 **结束后 10s 内** 仍刷新边界闪烁。  
- 曾就 **12:00 / 14:00** 起止与「全量是否一致」做过核对；**以当前文件内 `CONFIG` 与注释为唯一事实源**（当前约定为 **中午 12:00** 起、**+42 天同日 12:00** 止，上海）。

### 2. 白底上的对比与字重

- 白底时 **左下角/底部** `sparklab.city` 等：**深色字**、高亮色 **`#ed743d`**（替代早期偏深橙）；**`#residencyTagline`** 为常驻标语节点，**脚本不改其文案**（仅 `showCompletionMessage` 控制**上方**完成行显示）。  
- 白底 **左上角** Ship it 组件：深灰字、**进度条/轨道/标记** 对比度、填充色 **`rgba(255,103,55,0.6)`**（**暗色底** 下进度条仍保留 **偏棕橙** `rgba(200,80,40,0.7)`，曾明确 **勿改**）。  
- 白底 **右上角** 生命体征：沿用 **#ff6737** 系，**略提透明度** 以利白底阅读。  
- **字重**：白底上曾为 Ship it 三行 **500**、生命体征 **400**；后 **同步到暗色底** 同字重，避免仅白底加粗。  
- **Ship it Monday** 标题行 **`.community-dinner-label` 字号** 在双模式下略 **加大**（如约 **1.1vh → 1.45vh**）。

### 3. Ship it Monday（周进度）

- 由占位 **`Complete` + 100%** 改为 **按周真实进度**：**本周一 18:30（上海，S5）/ 本地（S3）** → **下周一 18:30** 为一周；**进度条、游标、日期、右侧倒计时** 与 **`elapsed/total`** 一致；**`total>0`** 防除零。  
- S3 曾含 **重复** 的 `getCurrentWeekStart` / `getNextWeekStart` 实现，**已去重** 保留一套。  
- **S5** 周锚与 `formatDate` 等以 **`Asia/Shanghai`** 为主，**`Intl` 不可用时** 对 **YMD/星期/时钟** 等做 **本机回退**。

### 4. 仪式、声学与杂项

- **21:00 仪式（S5）** 使用 **上海时、分、秒**；`getShanghaiClock` **try/catch**，失败则 **本机** 时、分、秒。  
- **`triggerRitual`** 对 **overlay / message** **判空**；**`resize`** 中 **`matrix-bg`** **判空**。

### 5. 仓库与元文件（非单页内）

- **根目录**仅保留 **S5** 主 HTML；**`archive/`** 存 **S3** 等旧版，并附 **简短 README**。  
- **`README` / `docs/github-setup` / `.gitignore`** 与组织私有库 **`residency-countdown`** 的说明、推送速查。  
- **徽标**使用 **Shields.io**，**Awesome** 为视觉风格，**不表示**入选外部 Awesome 列表。  
- **README（`main` 持续维护，未改初衷）**：仍以 **单文件、无构建、内部自用** 为中心；**网络使用** 中 **内网 NAS** 优先，**Vercel 公网** 为备选；**联系与审核** 写明 [Jah-yee](https://github.com/Jah-yee)、[WorldSansha / 三傻](https://github.com/WorldSansha)；文末 **维护者** 为 [本仓库](https://github.com/Spark-Lab-Global/residency-countdown) 的 contrib.rocks 图；**本地下载** 与 **技术说明** 下 **1Panel**、**Vercel** 根配置 等同前。

### 6. 有意未纳入或不在此仓库的内容

- **无 `LICENSE` 文件**：README 中声明 **内部使用**；是否开源由组织另定。  
- **S3 线** 曾用 **当年本地月日** 的 11/2–12/14 周期，与 S5 上海线 **并存于归档**，不作强行统一。

---

## 三、以后怎么维护

- **改 Residency 起止/闪烁**：**只改** `S5-Residency-Countdown.html` 内 **CONFIG/ISO/注释**，并在此文件 **按日期** 在 **第一节之上** 追加一条 **Git 级** 说明；若动到 **单页行为**，在 **第二节** 相应主题下 **补一条** 制品说明。  
- 需要 **语义化版本** 时，可再增加 **`[v0.x.y]`** 与 **Git tag**；当前以 **日期 + 提交表** 为主已够用。

---

*本文在整合对话追溯与 `git log` 时，若与本地 **reflog** 中旧 commit 有出入，**以 `main` 上可检出之对象为准**。*
