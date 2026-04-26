<div align="center">

# 倒计时

Spark Lab Residency 自用 · 全屏倒计时  
单文件，打开即用

</div>

<p align="center">
  <a href="https://github.com/Spark-Lab-Global"><img src="https://img.shields.io/badge/Spark%20Lab-Global-111111?style=flat-square&logo=github&labelColor=222" alt="Spark Lab Global" /></a>
  <img src="https://img.shields.io/badge/HTML5-single%20file-E34F26?style=flat-square&logo=html5&logoColor=white" alt="HTML5" />
  <img src="https://img.shields.io/badge/build-none-555555?style=flat-square" alt="No build" />
  <img src="https://img.shields.io/badge/Awesome-yes-ff69b4?style=flat-square&logo=awesomelists&logoColor=white" alt="Awesome" />
  <img src="https://img.shields.io/badge/repo-private-6e40c9?style=flat-square&logo=github" alt="Private" />
</p>

<p align="center">
  <a href="#网络使用">网络</a> · <a href="#本地下载">本地下载</a> · <a href="#技术说明">技术</a> · <a href="#联系与审核">联系</a> · <a href="#修改规范">规范</a> · <a href="#维护者">维护者</a> · <a href="CHANGELOG.md">更新记录</a>
</p>

---

## 网络使用

在浏览器中打开全屏页即可（与主文件 `S5-Residency-Countdown.html` 一致）。**优先**用下表 **1**；**不在内网**时，公网入口见下表 **2**（或备选 **3**），或最下方「本地下载」到本地。
在浏览器中打开全屏页即可（与主文件 `S5-Residency-Countdown.html` 一致）。**优先**用下表 **1**；**不在内网**时，公网入口见下表 **2** 与段后**国内镜像**二选一，或最下方「本地下载」到本地。

| # | 方式 | 地址与说明 |
|---|------|------------|
| 1 | **内网（推荐）** | <http://10.10.10.4:5000/>（**NAS** 上部署；仅**内网**可达，未连内网时打不开是正常现象。）<br>先接 **Spark Lab** 或 **Spark Lab-5G** 的 **WiFi**，或同网段有线，再在浏览器中打开。无需从 GitHub 下载。 |
| 2 | **公网（推荐）** | <https://residency-countdown.rth1.xyz/>：经 [**热铁盒网页托管**](https://host.retiehe.com/) 在国内环境构建的镜像，**不依赖**境外 CDN，适合国内网络直连访问，速度较快且稳定。 |
| 3 | **公网（备选·Vercel）** | <https://residency-countdown.vercel.app/>：仓库在 **Vercel** 上部署；CDN 在**国内未加速**，可能偏慢或偶发卡顿。若**能稳定访问** Vercel（常需**境外网络或挂 VPN**）或主公网链接失效时可作为备选。页面里 **Google Fonts** 等走公网拉取。 |

**公网在国内怎么选**（与上表 2、3 同一套单页，只是访问路径不同）：

- **日常国内直连**：优先使用 <https://residency-countdown.rth1.xyz/>，无网络环境限制，访问更稳定。
- **备选/有 VPN 环境**：当主公网链接异常，或本身处于境外网络/挂 VPN 时，可使用备用的 Vercel 链接 <https://residency-countdown.vercel.app/>。
| 2 | **公网·Vercel** | <https://residency-countdown.vercel.app/>：仓库在 **Vercel** 上部署；**能稳定访问** Vercel 时（常需**境外网络或挂 VPN**）可直接点链接打开。CDN 在**国内未加速**，可能偏慢或偶发卡顿，另有免费档用量等限制；页面里 **Google Fonts** 等走公网拉取。更稳可仍用 **1** 或**本地下载**本地打开。 |

**公网在国内怎么选**（与上表 2 同一套单页，只是访问路径不同）：

- **有 VPN 或能正常打开 Vercel 官网**时：优先用 <https://residency-countdown.vercel.app/> 即可。  
- **没挂 VPN**、在**国内**，或 **Vercel 页面打不开/很慢**时：可点 <https://tomato193.rth1.xyz/> —— 经 [**热铁盒网页托管**](https://host.retiehe.com/) 在国内环境构建的镜像，**不依赖** Vercel 境外 CDN，一般更适合当前网络。  

内网 **IP/端口** 若调整，以维护者通知为准；Vercel 的用量以 [Vercel](https://vercel.com) 为准；国内镜像以托管与 DNS 实际解析为准。

---

## 本地下载

适用场景：不在内网、或想拿一份**本地副本**随开随用。  
**默认操作**：先从 GitHub 把 **`S5-Residency-Countdown.html`** 存到本机，再在资源管理器里**双击**该文件，或用浏览器的「打开文件 / Open File」从磁盘选择它（和打开别的 `.html` 一样）。

> 点进主文件在仓库上的页面：  
> **[S5-Residency-Countdown.html（`main` 分支）](https://github.com/Spark-Lab-Global/residency-countdown/blob/main/S5-Residency-Countdown.html)**（也可从仓库 [根目录](https://github.com/Spark-Lab-Global/residency-countdown) 点进该文件。）

在文件**上方**的 GitHub 工具条，**任选一种**方式即可。

### 1. 推荐：直接下载

在**右侧**点 **「下载 / Download」** 或 **⋯** → **`Download raw file`**，把 `S5-Residency-Countdown.html` 存到本机，然后在资源管理器里**双击**打开；或用浏览器从磁盘**打开**该文件。

> 在页面上**对号入座**时，**「向下箭头/保存」** 与 **`Download raw file`** 常指同一类入口，只是 GitHub 版本可能显示成独立按钮或收在 `⋯` 里。  
>  
> <p align="center">
>   <img src="https://cdn.jsdelivr.net/npm/@primer/octicons@19.8.0/build/svg/download-24.svg" width="32" height="32" alt="下载（示意，与 Download raw file 对应）" />
> </p>

### 2. 备用：Raw

找不到上面入口时，点 **「Raw」**，**另存为**（Ctrl+S / ⌘+S）为 `.html` 即可。

---

## 技术说明

- **单文件**：HTML 内已含样式与脚本，无需构建。  
- **字体**：使用 Google Fonts，首次打开需能访问外网。  
- **时间与逻辑**：均写在该文件中；改期、改起止，只动这一处里配置区与相关注释所指的代码。

### 部署与参考（Reference）

- **内网 NAS**：与 **1Panel** 等从 GitHub 拉取/部署有关的做法，见博客  
  **[1Panel 自动同步 GitHub 仓库](https://blog.liushen.fun/posts/327826ac/)**（筑站与自动化思路，可按需对照你们 NAS 上的实际设置）。  
- **Vercel**：根目录的 **`vercel.json`** 仅把路径 **`/`** 重写到 **`S5-Residency-Countdown.html`**。这样**不增加** `index.html` 副本、主文件**仍只维护 S5 这一份**；`https://你的域名/S5-Residency-Countdown.html` 也仍可直链。若同站点将来要加其它资源路径，**不要**把全站 `/(.*)` 都重写到 S5，以免误伤。

---

## 联系与审核

仓库**内部**对接、主维护与**审核/协作**请优先联系（GitHub，好留痕、好抄送）：

- [**Jah-yee**](https://github.com/Jah-yee) — 主要开发、日常维护与发布。  
- [**WorldSansha（三傻）**](https://github.com/WorldSansha) — 内网 **NAS** 部署、同步与相关协作。  

> 公网 **Vercel**、**国内热铁盒镜像**与组织权限、私有库策略等，以实际维护者说明为准。  

---

## 修改规范

- 主发布：始终使用根目录 **`S5-Residency-Countdown.html`**。  
- 旧版：放在 **`archive/`**，不要与当前 S5 混用。  
- 远程：<https://github.com/Spark-Lab-Global/residency-countdown> · 首次推送等见 **`docs/github-setup.md`**（仅维护者）。

> 本仓库不单独附 License，内部使用。变更说明见 [**CHANGELOG.md**](CHANGELOG.md)。

---

## 维护者

<a href="https://github.com/Spark-Lab-Global/residency-countdown/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Spark-Lab-Global/residency-countdown" alt="本仓库贡献者" />
</a>