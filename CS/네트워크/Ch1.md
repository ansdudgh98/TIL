### A closer look at network structure
#### network edge :
applications and hosts

#### network core :
- routers
- network of networks

#### access networks physical media:
communication links

#### end systems(hosts) :
- run application programs
- e.g. Web, email
#### client/server model
- client host requests, receives service from always-on server
- e.g. Web brower/server,email client/server

#### peer-peer model :
- minimal use of dedicated servers
- e.g. Skype, BitTorrent, KaZaA

#### Network edge : connection-oriented service
Goal : data transfer between end systems

Connection: prepare for data transfer ahead of time
	- Request / Response
	- set up "state" in two communicating hosts
**TCP** - Transmission Control Protocol
- Internet's connection-oriented service

TCP service(RFC 793)
reliable, in-order-byte stream data transfer
- loss : acknowledgements and retransmissions
flow control :
- sender won't overwhelm receiver
congestion control :
- senders "slow down sending rate" when network congested

**UDP** - User Datagram Protocol(RFC 768)
- connections
- unreliable data transfer
- no flow control
- no congestion control

App's using TCP :
- HTTP,FTP,Telnet,SMTP

App's using UDP :
- streaming media, teleconferencing, DNS, Internet telephony


**What's protocol?**
- All communication in Internet coordinated by protocols



### Network Core
- mesh of interconneted routers
- the fundamental question : how is data transferred through net?
	- circuit switching : dedicated circuit per call : telephone net
	- packet switching : data sent thru net in discreate "chunks"

#### circuit switching -  End-end resources reserved for "call"
- link bandwidth, switch capacity
- dedicated resources: no sharing
- circuit - like (guaranteed) performance
- call setup required
![[Pasted image 20240116144023.png]]
#### packet switching : statisticla MultiPlexing
seqeunce of A&B packets does not have finxed pattern, shared on demand -> statical multiplexing
TDM : each host gets same slot in revolving TDM frame
![[Pasted image 20240116144320.png]]


### Packet switching vs circuit switching
Packet switching allows more users to use network

- 1 Mb/s link
- each user : 100 kb/s when "active", active 10% of time
- circuit switching : 10users
- packet switching : with 35 users, probability > 10 active less than .0004

### How do loss and delay occur?
#### packets queue in router buffers
- packet arrival rate to link exceeds output link capacity
- packets queue, wait for turn

#### Four sources of packet delay
1. nodal processing
	- check bit errors
	- determine output link
2. queueing
	- time waiting at output link for transmission
	- depends on congestion level of router
3. Transmission delay :
	- R = link bandwidth ( bps )
	- L = packet length (bits)
	- time to send bits into link = L/R
4. propagation delay :
	- d = length of physical link
	- s = propagation speed int medium( ~ 2 X 10^8 m/sec)
	- propagation delay = d/s
		(s and R are very different quantities)
