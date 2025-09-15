const API_BASE = 'http://localhost:8080';

export type Campaign = {
  id?: number;
  title: string;
  description: string;
  goalAmount: string;
  raisedAmount?: string;
};

export type Donation = {
  id?: number;
  donorName: string;
  amount: string;
};

export async function listCampaigns(): Promise<Campaign[]> {
  const res = await fetch(`${API_BASE}/api/crowdfunding/campaigns`);
  if (!res.ok) throw new Error('Failed to load campaigns');
  return res.json();
}

function authHeader(username?: string, password?: string): HeadersInit {
  if (!username || !password) return {};
  const token = btoa(`${username}:${password}`);
  return { Authorization: `Basic ${token}` };
}

export async function createCampaign(data: Campaign, username?: string, password?: string): Promise<Campaign> {
  const res = await fetch(`${API_BASE}/api/crowdfunding/campaigns`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      ...authHeader(username, password),
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error('Failed to create campaign');
  return res.json();
}

export async function donate(campaignId: number, data: Donation): Promise<Donation> {
  const res = await fetch(`${API_BASE}/api/crowdfunding/campaigns/${campaignId}/donations`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error('Failed to donate');
  return res.json();
}